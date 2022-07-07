package Cwiczenia.Hunter;

import Cwiczenia.Hunter.Board.Board;
import Cwiczenia.Hunter.Board.Tile;
import Cwiczenia.Hunter.Items.ComputerPiece;
import Cwiczenia.Hunter.Items.PlayerPiece;
import Cwiczenia.Hunter.Items.PlayingPiece;

import java.util.Random;
import java.util.Scanner;

public class Hunter {
    private static Board gameBoard;
    private static int globalTurn = 1;
    private PlayingPiece[] agents = new PlayingPiece[3];
    private PlayingPiece player;
    private boolean haGameEnded;


    public void startGame(PlayingPiece player) {
        Scanner scn = new Scanner(System.in);
        gameBoard = Board.getBoard();
        gameBoard.cleanBoard();
        initializeAgents();
        this.player = player;
        placePlayingPiecesOnBoard();

        do {
            gameBoard.displayBoard();
            printPlayerInstruction();
            System.out.print("\nYour move: ");
            String playerMove = scn.nextLine().toUpperCase();
            resolveMovement(playerMove);
            globalTurn++;
        }while (!haGameEnded);

    }

    private void placePlayingPiecesOnBoard() {
        Random rnd = new Random();
        int positionX;
        int positionY;
        int counter = agents.length - 1;
        while (counter >= 0 ) {
            positionX = rnd.nextInt(gameBoard.BOARD_ROW);
            positionY = rnd.nextInt(gameBoard.BOARD_ROW);

            if(gameBoard.getBoardTile(positionX, positionY).isOccupied() || !gameBoard.getBoardTile(positionX, positionY).getType().isTraversable()) {
                continue;
            }
            gameBoard.getBoardTile(positionX,positionY).playingPieceEnter(agents[counter]);
            counter--;
        }

        insterPLayerToStartingPosition();
    }

    private void insterPLayerToStartingPosition() {
        Random rnd = new Random();
        int positionX;
        int positionY;
        boolean isPlayerReady = false;
        while (!isPlayerReady) {
            positionX = rnd.nextInt(gameBoard.BOARD_ROW);
            positionY = rnd.nextInt(gameBoard.BOARD_ROW);

            if(!isSquareSafe(positionX, positionY) || !gameBoard.getBoardTile(positionX, positionY).getType().isTraversable()) {
                continue;
            }
            gameBoard.getBoardTile(positionX,positionY).playingPieceEnter(player);
            isPlayerReady = true;
        }
    }

    private boolean isSquareSafe(int positionX, int positionY){
        Tile[][] surroundingSquare = gameBoard.returnSurroundingSquare(positionX,positionY);

        for (Tile[] tiles : surroundingSquare) {
            for (Tile tile : tiles) {
                if(tile == null || tile == gameBoard.getBoardTile(positionX,positionY)) {
                    continue;
                } else if (tile.isOccupied()) {
                    return false;
                }
            }
        }
        return true;
    }

    private void resolveMovement(String playerMovement) {

    }

    private void initializeAgents() {
        for (int i = 0; i < agents.length; i++) {
            agents[i] = new ComputerPiece();
        }
    }

    public void printPlayerInstruction() {
        System.out.println("\t\t\t\t\tPLAN YOUR MOVES\t\t\t\tTURN: " + globalTurn);
        System.out.println("W - MOVE UP | " + "S - MOVE DOWN | " + "A - MOVE LEFT | " + "D - MOVE RIGHT");
    }


}
