package Hunter.Items;

public class PlayerPiece extends PlayablePiece {

    public PlayerPiece(String playerSymbol) {
        playerSymbol = playerSymbol.replaceAll("\\W", "P");
        setPlayablePieceSymbol("[" + playerSymbol + "]");
    }

    @Override
    public String toString() {
        return getPlayablePieceSymbol();
    }
}
