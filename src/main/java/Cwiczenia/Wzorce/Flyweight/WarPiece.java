package Cwiczenia.Wzorce.Flyweight;

public class WarPiece {
    private int positionX;
    private int positionY;
    private WarPieceStats warPieceStats;

    public WarPiece(int positionX, int positionY, String warPiece) {
        this.positionX = positionX;
        this.positionY = positionY;

        switch (warPiece) {
            case "tank":
                this.warPieceStats = WarPieceValues.getTank();
                break;
            case "rifleman":
                this.warPieceStats = WarPieceValues.getRifleman();
                break;
            case "destroyer":
                this.warPieceStats = WarPieceValues.getDestroyer();
                break;
            default:
                this.warPieceStats = WarPieceValues.getRifleman();
                break;

        }

    }

    @Override
    public String toString() {
        return "WarPiece{" +
                "positionX= " + positionX +
                ", positionY= " + positionY +
                ", Stats= " + warPieceStats +
                '}';
    }
}
