package Cwiczenia.Hunter.Items;

public abstract class PlayingPiece {
    private int positionX;
    private int positionY;
    private String playingPieceSymbol;



    public String getPlayingPieceSymbol() {
        return playingPieceSymbol;
    }

    public void setPlayingPieceSymbol(String playingPieceSymbol) {
        this.playingPieceSymbol = playingPieceSymbol;
    }

    public void moveToPosition(int positionX, int positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }
}
