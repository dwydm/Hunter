package Cwiczenia.Hunter.Board;

import Cwiczenia.Hunter.Items.PlayerPiece;
import Cwiczenia.Hunter.Items.PlayablePiece;

public class Tile {
    private TileType tileType;
    private int positionX;
    private int positionY;
    private PlayablePiece playablePiece;
    private boolean occupied;

    public Tile(int positionX, int positionY, TileType tileType) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.tileType = tileType;

    }

    public void playingPieceEnter(PlayablePiece playablePiece) {
        if (getType() == TileType.WALL) {
            return;
        }

        playablePiece.moveToPosition(positionX, positionY);

        this.playablePiece = playablePiece;
        occupied = true;

    }

    public PlayablePiece getPlayablePiece() {
        return playablePiece;
    }

    public void playingPieceLeave() {
        playablePiece = null;
        occupied = false;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setSpecialTile(TileType tileType) {
        this.tileType = tileType;
    }

    public TileType getType() {
        return tileType;
    }

    @Override
    public String toString() {
        if (occupied && tileType != TileType.HEDGE || playablePiece instanceof PlayerPiece) {
            return playablePiece.getPlayablePieceSymbol();
        }
        return tileType.getBoardMark();
    }
}
