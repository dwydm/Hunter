package Cwiczenia.Hunter;

import Cwiczenia.Hunter.Board.Board;
import Cwiczenia.Hunter.Items.ComputerPiece;
import Cwiczenia.Hunter.Items.PlayingPiece;

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

        do {
            gameBoard.displayBoard();
            printPlayerInstruction();
            System.out.print("\nYour move: ");
            String playerMove = scn.nextLine().toUpperCase();
            resolveMovement(playerMove);
            globalTurn++;
        }while (!haGameEnded);

    }

    private void resolveMovement(String playerMovement) {

    }

    private void initializeAgents() {
        for (PlayingPiece agent : agents) {
            agent = new ComputerPiece();
        }
    }

    public void printPlayerInstruction() {
        System.out.println("\t\t\t\t\tPLAN YOUR MOVES\t\t\t\tTURN: " + globalTurn);
        System.out.println("W - MOVE UP | " + "S - MOVE DOWN | " + "A - MOVE LEFT | " + "D - MOVE RIGHT");
    }


}
