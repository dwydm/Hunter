package Cwiczenia.Hunter;

import Cwiczenia.Hunter.Board.Board;

public class HunterDemo {

    public static void main(String[] args) {
        Hunter hunter = new Hunter();
        Board board = Board.getBoard();

        board.cleanBoard();
        board.displayBoard();
        hunter.printPlayerInstruction();

    }
}
