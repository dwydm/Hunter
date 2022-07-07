package Cwiczenia.Hunter.Items;

public abstract class PlayablePiece {
    private int positionX;
    private int positionY;
    private String playablePieceSymbol;


    public String getPlayablePieceSymbol() {
        return playablePieceSymbol;
    }

    public void setPlayablePieceSymbol(String playablePieceSymbol) {
        this.playablePieceSymbol = playablePieceSymbol;
    }

    public void moveToPosition(int positionX, int positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }
}
