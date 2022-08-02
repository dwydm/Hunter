package Cwiczenia.Wzorce.Factory;

public class BasicUnitFactory extends UnitFactory {
    @Override
    public Alien createAlien(String alienType) {
        switch (alienType) {
            case "muton":
                return new Muton("Muton grunt", 100);
            case "sectoid":
                return new Sectoid("Sectoid grunt", 150);
            default:
                return null;
        }
    }

    @Override
    public Human createHuman(String humanRank) {
        switch (humanRank) {
            case "marine":
                return new Marine(300, 200);
            case "psi":
                return new Psi(200, 100);
            default:
                return null;
        }
    }
}
