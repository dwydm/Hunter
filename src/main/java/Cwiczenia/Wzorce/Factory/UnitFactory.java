package Cwiczenia.Wzorce.Factory;

public abstract class UnitFactory {
    public abstract Alien createAlien(String alienType);
    public abstract Human createHuman(String humanRank);
}
