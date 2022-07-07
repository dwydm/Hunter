package Cwiczenia.Hunter.Items;

public class ComputerPiece extends PlayingPiece {

    public ComputerPiece() {
        setPlayingPieceSymbol("[&]");
    }

    @Override
    public String toString() {
        return getPlayingPieceSymbol();
    }
}
