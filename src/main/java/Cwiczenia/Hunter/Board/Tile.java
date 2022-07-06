package Cwiczenia.Hunter.Board;

import Cwiczenia.Hunter.Items.PlayingPiece;

public class Tile {
    private TileType tileType;
    private PlayingPiece playingPiece;
    private int positionX;
    private int positionY;

    public Tile(int positionX, int positionY, TileType tileType){
        this.positionX = positionX;
        this.positionY = positionY;

        if(tileType == TileType.FLOOR) {
            this.tileType = tileType;
        }
    }


    public TileType getType() {
        return tileType;
    }


}
