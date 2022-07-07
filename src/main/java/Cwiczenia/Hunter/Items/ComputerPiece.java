package Cwiczenia.Hunter.Items;

public class ComputerPiece extends PlayablePiece {

    public ComputerPiece() {
        setPlayablePieceSymbol("[&]");
    }

    @Override
    public String toString() {
        return getPlayablePieceSymbol();
    }
}
