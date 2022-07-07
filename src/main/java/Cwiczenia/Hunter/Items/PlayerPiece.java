package Cwiczenia.Hunter.Items;

public class PlayerPiece extends PlayablePiece {

    public PlayerPiece(String playerSymbol) {
        setPlayablePieceSymbol("[" + playerSymbol + "]");
    }

    @Override
    public String toString() {
        return getPlayablePieceSymbol();
    }
}
