package Cwiczenia.Hunter.Items;

public class PlayerPiece extends PlayingPiece {

    public PlayerPiece(String playerSymbol){
        setPlayingPieceSymbol(playerSymbol);
    }

    @Override
    public String toString() {
        return getPlayingPieceSymbol();
    }
}
