package Cwiczenia.Hunter.Board;

import Cwiczenia.Hunter.Items.PlayingPiece;

public class Tile {
    private TileType tileType;
    private int positionX;
    private int positionY;
    private String boardMark;
    private PlayingPiece playingPiece;

    public Tile(int positionX, int positionY, TileType tileType){
        this.positionX = positionX;
        this.positionY = positionY;
        this.tileType = tileType;

        if(tileType == TileType.FLOOR) {
            boardMark = "[ ]";
        } else if (tileType == TileType.HEDGE) {
            boardMark = "[#]";
        } else if (tileType == TileType.WALL) {
            boardMark = "[=]";
        }
    }


    public TileType getType() {
        return tileType;
    }


}
