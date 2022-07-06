package Cwiczenia.Hunter;

import Cwiczenia.Hunter.Board.Board;

public class Hunter {
    private static int turn = 2;
    private static Board gameBoard;


    public void startGame() {
        gameBoard = Board.getBoard();

        do {
            gameBoard.displayBoard();

        }while (true);

    }


}
