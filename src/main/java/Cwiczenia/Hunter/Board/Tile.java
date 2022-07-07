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

    public void playingPieceEnter(PlayingPiece playingPiece) {
        if(getType() == TileType.WALL) {
            return;
        }
        this.playingPiece = playingPiece;
        occupied = true;

    }

    public PlayingPiece getPlayingPiece() {
        return playingPiece;
    }

    public void playingPieceLeave() {
        playingPiece = null;
        occupied = false;
    }

    public boolean isOccupied(){
        return occupied;
    }

    public void setSpecialTile(TileType tileType){
        this.tileType = tileType;
    }

    public TileType getType() {
        return tileType;
    }

    @Override
    public String toString() {
        if(occupied && tileType != TileType.HEDGE || playingPiece instanceof PlayerPiece) {
            return playingPiece.getPlayingPieceSymbol();
        }
        return tileType.getBoardMark();
    }
}
