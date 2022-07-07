package Cwiczenia.Hunter.Board;

import Cwiczenia.Hunter.Items.PlayerPiece;
import Cwiczenia.Hunter.Items.PlayingPiece;

public class Tile {
    private TileType tileType;
    private int positionX;
    private int positionY;
    private PlayingPiece playingPiece;
    private boolean occupied;

    public Tile(int positionX, int positionY, TileType tileType){
        this.positionX = positionX;
        this.positionY = positionY;
        this.tileType = tileType;

    }

    public void playingPieceEnter() {
        if(getType() == TileType.WALL) {
            return;
        }

    }

    public void playingPieceLeave() {


    }

    public void setSpecialTile(TileType tileType){
        this.tileType = tileType;
    }

    public TileType getType() {
        return tileType;
    }

    @Override
    public String toString() {
        if(occupied) {
            return playingPiece.getPlayingPieceSymbol();
        }
        return tileType.getBoardMark();
    }
}
