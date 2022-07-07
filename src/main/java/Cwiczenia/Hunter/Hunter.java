package Cwiczenia.Hunter;

import Cwiczenia.Hunter.Board.Board;
import Cwiczenia.Hunter.Items.PlayingPiece;

public class Hunter {
    private static int turn = 2;
    private static Board gameBoard;
    private static PlayingPiece player;


    public void startGame() {
        gameBoard = Board.getBoard();

        do {
            gameBoard.displayBoard();
            printPlayerInstruction();


        }while (true);

    }

    public void printPlayerInstruction() {
        System.out.println("\t\t\t\t\tPLAN YOUR MOVES");
        System.out.println("W - MOVE UP | " + "S - MOVE DOWN | " + "A - MOVE LEFT | " + "D - MOVE RIGHT");
    }


}
