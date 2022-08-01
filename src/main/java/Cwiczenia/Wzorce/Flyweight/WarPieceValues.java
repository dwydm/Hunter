package Cwiczenia.Wzorce.Flyweight;

public class WarPieceValues {
    private static WarPieceStats tank = new WarPieceStats(150,300,40,1500);
    private static WarPieceStats rifleman = new WarPieceStats(80,60, 60,300);
    private static WarPieceStats destroyer = new WarPieceStats(600, 800,100,2500);


    public static WarPieceStats getTank() {
        return tank;
    }

    public static WarPieceStats getRifleman() {
        return rifleman;
    }

    public static WarPieceStats getDestroyer() {
        return destroyer;
    }
}
