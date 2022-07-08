package Cwiczenia.Hunter;

import Cwiczenia.Hunter.Board.Board;
import Cwiczenia.Hunter.Board.Tile;
import Cwiczenia.Hunter.Board.TileType;
import Cwiczenia.Hunter.Items.ComputerPiece;
import Cwiczenia.Hunter.Items.PlayablePiece;
import Cwiczenia.Hunter.Items.PlayerPiece;

import java.util.*;

public class Hunter {

    {
        gameBoard = Board.getBoard();
        gameBoard.cleanBoard();
    }

    private final static int NUMBER_OF_AGENTS = 3;
    private List<ComputerPiece> agents = new ArrayList<>(NUMBER_OF_AGENTS);
    private List<String> playerMoves = new ArrayList<>();
    private static Board gameBoard;
    private static int globalTurn = 1;
    private PlayablePiece player;
    private boolean haGameEnded;
    private boolean isPlayerAWinner;


    public void startGame(PlayablePiece player) {
        Scanner scn = new Scanner(System.in);
        this.player = player;
        initializeAgents();
        placePlayingPiecesOnBoard();

        do {
            gameBoard.displayBoard();
            printPlayerInstruction();
            System.out.print("\nYour move: ");
            String playerMove = scn.nextLine().toUpperCase();
            resolveTurnMovement(playerMove);
            globalTurn++;
        } while (!haGameEnded);
        displayGameOverMsg(isPlayerAWinner);

    }

    private void displayGameOverMsg(boolean isPlayerAWinner) {
        if (isPlayerAWinner) {
            System.out.println("\n\n\n\t\t\t\t\tCONGRATULATIONS!\n\n");
        } else {
            System.out.println("\n\n\n\t\t\t\t\t\tGAME OVER\n\n");
        }
/*        for (int i = 1; i <= playerMoves.size(); i++) { //TODO: wyświetlanie ruchów gracza po sesji
            System.out.print(playerMoves.get(i-1) + "\t\t");
            if(i % 4 == 0) {
                System.out.println();
            }
        }
        System.out.println();*/
    }

    private void placePlayingPiecesOnBoard() {
        Random rnd = new Random();
        int positionX;
        int positionY;
        int counter = agents.size() - 1;
        while (counter >= 0) {
            positionX = rnd.nextInt(gameBoard.BOARD_ROW);
            positionY = rnd.nextInt(gameBoard.BOARD_ROW);

            if (gameBoard.getBoardTile(positionX, positionY).isOccupied() || !gameBoard.getBoardTile(positionX, positionY).getType().isTraversable()) {
                continue;
            }
            gameBoard.getBoardTile(positionX, positionY).playingPieceEnter(agents.get(counter));
            counter--;
        }

        placePLayerToStartingPosition();
    }

    private void placePLayerToStartingPosition() {
        Random rnd = new Random();
        int positionX;
        int positionY;
        boolean isPlayerReady = false;
        while (!isPlayerReady) {
            positionX = rnd.nextInt(gameBoard.BOARD_ROW);
            positionY = rnd.nextInt(gameBoard.BOARD_ROW);

            if (!isSquareSafe(positionX, positionY) || !gameBoard.getBoardTile(positionX, positionY).getType().isTraversable()) {
                continue;
            }
            gameBoard.getBoardTile(positionX, positionY).playingPieceEnter(player);
            isPlayerReady = true;
        }
    }

    private boolean isSquareSafe(int positionX, int positionY) {
        Tile[][] surroundingSquare = gameBoard.returnSurroundingSquare(positionX, positionY);   //Board zwraca 8 obiektów Tile wokół przekazanego środka
        //pola poza krawędzią Board są null
        for (Tile[] tiles : surroundingSquare) {
            for (Tile tile : tiles) {
                if (tile == null || tile == gameBoard.getBoardTile(positionX, positionY)) {
                    continue;
                } else if (tile.isOccupied()) {
                    return false;
                }
            }
        }
        return true;
    }

    private void resolveTurnMovement(String playerMovement) {
        String[] playerMovementArray = playerMovement.split("\s");
        agentsMovement();
        playerSetDirection(playerMovementArray);

    }

    private void playerSetDirection(String[] playerMovementArray) {
        String moves = "Turn: " + globalTurn + " Moves:";
        for (String direction : playerMovementArray) {
            int posX = player.getPositionX();
            int posY = player.getPositionY();
            switch (direction.toUpperCase()) {
                case "W":
                    posY += (-1);
                    moves += " " + direction;
                    playablePieceMove(player, posX, posY);
                    break;
                case "S":
                    posY += 1;
                    moves += " " + direction;
                    playablePieceMove(player, posX, posY);
                    break;
                case "A":
                    posX += (-1);
                    moves += " " + direction;
                    playablePieceMove(player, posX, posY);
                    break;
                case "D":
                    posX += 1;
                    moves += " " + direction;
                    playablePieceMove(player, posX, posY);
                    break;
                default:

            }
        }
        playerMoves.add(moves);
    }

    private void playablePieceMove(PlayablePiece playablePiece, int posX, int posY) {
        Tile destinationBoardTile = gameBoard.getBoardTile(posX, posY);
        if (destinationBoardTile == null || !destinationBoardTile.getType().isTraversable()) {
            return;
        } else if (destinationBoardTile.isOccupied() && !isFriendly(playablePiece, destinationBoardTile.getPlayablePiece())) {
            resolvePlayablePieceConflict(playablePiece, destinationBoardTile);

        } else if (!destinationBoardTile.isOccupied()) {
            gameBoard.getTileContainingObject(playablePiece).playingPieceLeave();   //opuszcza zajmowany kwadrat
            playablePiece.moveToPosition(posX, posY);                                //PlayablePiece otrzymuje nową pozycję
            destinationBoardTile.playingPieceEnter(playablePiece);                  //Tile przyjmuje obiekt PlayablePiece
        }
    }

    private void resolvePlayablePieceConflict(PlayablePiece playablePiece, Tile boardTile) {
        if (boardTile.getPlayablePiece() instanceof ComputerPiece && agents.size() <= 1) {  // wygrana
            agents.remove(boardTile.getPlayablePiece());        //z listy agentow usuwany jest obiekt PlayablePiece zwracany przez Tile
            boardTile.playingPieceLeave();
            isPlayerAWinner = true;
            haGameEnded = true;
        } else if (boardTile.getPlayablePiece() instanceof ComputerPiece) {                 //zbicie, gra w toku
            agents.remove(boardTile.getPlayablePiece());
            boardTile.playingPieceLeave();
            gameBoard.getBoardTile(playablePiece.getPositionX(), playablePiece.getPositionY()).playingPieceLeave();
            boardTile.playingPieceEnter(playablePiece);
        } else if (boardTile.getPlayablePiece() instanceof PlayerPiece) {                   //przegrana
            isPlayerAWinner = false;
            haGameEnded = true;
        }
    }

    private void agentsMovement() {
        Tile[][] agentSurroundings;
        Tile destinationMoveTile;

        for (ComputerPiece agent : agents) {
            agentSurroundings = gameBoard.returnSurroundingSquare(agent.getPositionX(), agent.getPositionY());
            destinationMoveTile = assesAgentViableActions(agent, agentSurroundings);
            playablePieceMove(agent,destinationMoveTile.getPositionX(),destinationMoveTile.getPositionY());

        }

    }

    private Tile assesAgentViableActions(ComputerPiece agent, Tile[][] agentSurroundings) {
        ArrayList<Tile> viableMoves = new ArrayList<>();
        for (Tile[] tiles : agentSurroundings) {
            for (Tile tile : tiles) {
                if (tile == null || tile.getType() == TileType.WALL) {
                    continue;
                } else if (tile.isOccupied() && !isFriendly(agent, tile.getPlayablePiece()) && isInMovementRange(agent,tile)) {
                    if(tile.getType() == TileType.HEDGE) {      //ignoruje gracza w krzakach
                        continue;
                    }
                    return tile;
                } else if (!tile.isOccupied() && isInMovementRange(agent,tile) &&tile.getType().isTraversable()) {
                    viableMoves.add(tile);
                }
            }
        }
        if (!viableMoves.isEmpty()) {
            Collections.shuffle(viableMoves);
            return viableMoves.get(0);
        }
        return gameBoard.getTileContainingObject(agent);
    }

    private boolean isInMovementRange(ComputerPiece agent, Tile destinationTile) {      //zapobiega bieganiu agentów po skosie
        int agentPos = agent.getPositionY() + agent.getPositionX();
        int tilePos = destinationTile.getPositionY() + destinationTile.getPositionX();
        if(agentPos - tilePos == 1 || agentPos - tilePos == -1) {
            return true;
        }

        return false;
    }

    private boolean isFriendly(PlayablePiece attacker, PlayablePiece deffender) {
        if (attacker.getPlayablePieceSymbol().equalsIgnoreCase(deffender.getPlayablePieceSymbol())) {
            return true;
        }
        return false;
    }

    private void initializeAgents() {
        for (int i = 0; i < NUMBER_OF_AGENTS; i++) {
            agents.add(new ComputerPiece());
        }
    }

    public void printPlayerInstruction() {
        System.out.println("AGENTS: " + agents.size() + "\t\t\tPLAN YOUR MOVES\t\t\t\tTURN: " + globalTurn);
        System.out.println("W - MOVE UP | " + "S - MOVE DOWN | " + "A - MOVE LEFT | " + "D - MOVE RIGHT");
    }


}
