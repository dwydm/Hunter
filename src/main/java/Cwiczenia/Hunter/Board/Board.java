package Cwiczenia.Hunter.Board;

public class Board {
    private Tile[][] gameBoard;

    private static Board board;

    private Board() {
        gameBoard = new Tile[10][10];
    }

    public static Board getBoard(){
        if(board == null) {
            return new Board();
        }
        return board;
    }

    private void fillBoardWithFloorTiles(){

    }
    public void displayBoard() {
        for (Tile[] tiles : gameBoard) {
            for (Tile tile : tiles) {
                System.out.print("|");

            }

        }
    }
}
