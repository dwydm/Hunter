package Cwiczenia.Hunter.Board;

import java.util.Random;

public class Board {
    private final int MINIMUM_HEDGES = 5;
    private final int MAXIMUM_HEDGES = 16;
    private final int MINIMUM_WALLS = 3;
    private final int MAXIMUM_WALLS = 10;
    public final int BOARD_ROW = 10;
    private Tile[][] gameBoard;

    private static Board board;

    private Board() {
        gameBoard = new Tile[BOARD_ROW][BOARD_ROW];
    }

    public static Board getBoard(){
        if(board == null) {
            return new Board();
        }
        return board;
    }

    public Tile getBoardTile(int x, int y) {
        if((x >= 0 && x < BOARD_ROW) && (y >= 0 && y < BOARD_ROW)) {
            return gameBoard[y][x];
        }
        return null;
    }

    public void cleanBoard() {
        fillBoardWithFloorTiles();
        fillBoardWithSpecialTiles();
    }

    private void fillBoardWithSpecialTiles() {
        Random rnd = new Random();
        createHedges(rnd.nextInt(MAXIMUM_HEDGES) + MINIMUM_HEDGES);
        createWalls(rnd.nextInt(MAXIMUM_WALLS) + MINIMUM_WALLS);

    }

    private void createWalls(int numberOfWalls) {
        Random rnd = new Random();
        int positionX;
        int positionY;
        while (numberOfWalls > 0) {
            positionY = rnd.nextInt(gameBoard.length - 2) + 1; // nie pozwala na tworzenie ścian przy krawędziach
            positionX = rnd.nextInt(gameBoard.length - 2) + 1;
            if(getBoardTile(positionX,positionY).getType() != TileType.FLOOR) {
                continue;
            }
            getBoardTile(positionX,positionY).setSpecialTile(TileType.WALL);
            numberOfWalls--;
        }
    }

    private void createHedges(int numberOfHedges) {
        Random rnd = new Random();
        int positionX;
        int positionY;
        while (numberOfHedges > 0) {
            positionY = rnd.nextInt(gameBoard.length);
            positionX = rnd.nextInt(gameBoard.length);
            if(getBoardTile(positionX,positionY).getType() != TileType.FLOOR) {
                continue;
            }
            getBoardTile(positionX,positionY).setSpecialTile(TileType.HEDGE);
            numberOfHedges--;
        }
    }

    private void fillBoardWithFloorTiles(){
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                gameBoard[i][j] = new Tile(j,i,TileType.FLOOR);
            }
        }
    }

    public Tile[][] returnSurroundingSquare(int centerPositionX, int centerPositionY) {
        Tile[][] smallSquare = new Tile[3][3];
        int yAxis = centerPositionY - 1;
        int xAxis = centerPositionX - 1;

        for (int i = 0; i < smallSquare.length; i++) {
            for (int j = 0; j < smallSquare[i].length; j++) {
                smallSquare[i][j] = getBoardTile(xAxis, yAxis);
                xAxis++;
            }
            yAxis++;
        }
        return smallSquare;
    }

    public void displayBoard() {
        for (int i = 0; i < gameBoard.length; i++) {
            System.out.print("| ");
            for (Tile tile : gameBoard[i]) {
                System.out.print(tile + " | ");
            }
            if(i == 2) {
                System.out.print("\t\t& - enemy, computer agents");
            }
            if(i == 3) {
                System.out.print("\t\t# - hedge, players may hide in here");
            }
            if(i == 4) {
                System.out.print("\t\t= - wall, players are unable to walk through it ");
            }
            if(i == 6) {
                System.out.print("\t\t>>> plan your 2 moves ahead, typing W,S,A or D separated with space ' '");
            }
            if(i == 7) {
                System.out.print("\t\t>>> Example input: \"W D\", step on a tile with enemy agents to take them out");
            }
            if(i == 8) {
                System.out.print("\t\t>>> Caution, you have two moves, but agents react first in a turn");
            }
            System.out.println();

        }

    }
}
