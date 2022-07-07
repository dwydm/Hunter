package Cwiczenia.Hunter;

import Cwiczenia.Hunter.Board.Board;
import Cwiczenia.Hunter.Board.Tile;
import Cwiczenia.Hunter.Items.ComputerPiece;
import Cwiczenia.Hunter.Items.PlayablePiece;
import Cwiczenia.Hunter.Items.PlayerPiece;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Hunter {

    {
        gameBoard = Board.getBoard();
        gameBoard.cleanBoard();
    }

    private final static int NUMBER_OF_AGENTS = 3;
    private static Board gameBoard;
    private static int globalTurn = 1;
    private List<ComputerPiece> agents = new ArrayList<>(NUMBER_OF_AGENTS);
    private PlayablePiece player;
    private boolean haGameEnded;
    private boolean isPlayerAWinner;


    public void startGame(PlayablePiece player) {
        Scanner scn = new Scanner(System.in);
        this.player = player;
        initializeAgents();
        placePlayingPiecesOnBoard();
/*        gameBoard = Board.getBoard();
        gameBoard.cleanBoard();
        initializeAgents();
        this.player = player;
        placePlayingPiecesOnBoard();*/

        do {
            gameBoard.displayBoard();
            printPlayerInstruction();
            System.out.print("\nYour move: ");
            String playerMove = scn.nextLine().toUpperCase();
            resolveMovement(playerMove);
            globalTurn++;
        } while (!haGameEnded);
        displayGameOverMsg(isPlayerAWinner);

    }

    private void displayGameOverMsg(boolean isPlayerAWinner) {
        if (isPlayerAWinner) {
            System.out.println("\n\n\n\t\t\t\tCONGRATULATIONS!\n\n\n\n");
        } else {
            System.out.println("\n\n\n\t\t\t\t\tGAME OVER\n\n\n\n");
        }
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

        insertPLayerToStartingPosition();
    }

    private void insertPLayerToStartingPosition() {
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
        Tile[][] surroundingSquare = gameBoard.returnSurroundingSquare(positionX, positionY); //Board zwraca 8 obiektów Tile wokół przekazanego środka
        //pola poza krawędzią Board zwracają null!
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

    private void resolveMovement(String playerMovement) {
        if (playerMovement.isEmpty()) {
            agentsMovement();
        }
        String[] playerMovementArray = playerMovement.split("\s");
        playerSetDirection(playerMovementArray);

    }

    private void playerSetDirection(String[] playerMovementArray) {
        for (String direction : playerMovementArray) {
            int posX = player.getPositionX();
            int posY = player.getPositionY();
            switch (direction.toUpperCase()) {
                case "W":
                    posY += (-1);
                    playablePieceMove(player, posX, posY);
                    break;
                case "S":
                    posY += 1;
                    playablePieceMove(player, posX, posY);
                    break;
                case "A":
                    posX += (-1);
                    playablePieceMove(player, posX, posY);
                    break;
                case "D":
                    posX += 1;
                    playablePieceMove(player, posX, posY);
                    break;
                default:

            }
        }
    }

    private void playablePieceMove(PlayablePiece playablePiece, int posX, int posY) {
        Tile destinationBoardTile = gameBoard.getBoardTile(posX, posY);
        if (destinationBoardTile == null || !destinationBoardTile.getType().isTraversable()) {
            return;
        } else if (destinationBoardTile.isOccupied() && !isFriendly(playablePiece, destinationBoardTile.getPlayablePiece())) {
            resolvePlayablePieceConflict(playablePiece, destinationBoardTile);
        } else if (!destinationBoardTile.isOccupied()) {
            gameBoard.getTileContainingObject(playablePiece).playingPieceLeave();
            playablePiece.moveToPosition(posX,posY);
            destinationBoardTile.playingPieceEnter(playablePiece);
        }
    }

    private void resolvePlayablePieceConflict(PlayablePiece playablePiece, Tile boardTile) {
        if (boardTile.getPlayablePiece() instanceof ComputerPiece && agents.size() <= 1) {
            agents.remove(boardTile.getPlayablePiece());
            boardTile.playingPieceLeave();
            isPlayerAWinner = true;
            haGameEnded = true;
        } else if (boardTile.getPlayablePiece() instanceof ComputerPiece) {
            agents.remove(boardTile.getPlayablePiece());
            boardTile.playingPieceLeave();
            gameBoard.getBoardTile(playablePiece.getPositionX(), playablePiece.getPositionY()).playingPieceLeave();
            boardTile.playingPieceEnter(playablePiece);
        } else if (boardTile.getPlayablePiece() instanceof PlayerPiece) {
            isPlayerAWinner = false;
            haGameEnded = true;
        }
    }

    private boolean isFriendly(PlayablePiece attacker, PlayablePiece deffender){
        if (attacker.getPlayablePieceSymbol().equalsIgnoreCase(deffender.getPlayablePieceSymbol())){
            return true;
        }
        return false;
    }

    private void agentsMovement() {

    }

    private void initializeAgents() {
        for (int i = 0; i < NUMBER_OF_AGENTS; i++) {
            agents.add(new ComputerPiece());
        }
    }

    public void printPlayerInstruction() {
        System.out.println("\t\t\t\t\tPLAN YOUR MOVES\t\t\t\tTURN: " + globalTurn);
        System.out.println("W - MOVE UP | " + "S - MOVE DOWN | " + "A - MOVE LEFT | " + "D - MOVE RIGHT");
    }


}
