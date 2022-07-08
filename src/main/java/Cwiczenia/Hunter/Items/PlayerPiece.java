package Cwiczenia.Hunter.Items;

public class PlayerPiece extends PlayablePiece {

    public PlayerPiece(String playerSymbol) { //TODO: usunąć niedozwolone symbole z nazwy gracza
        setPlayablePieceSymbol("[" + playerSymbol + "]");
    }

    @Override
    public String toString() {
        return getPlayablePieceSymbol();
    }
}
