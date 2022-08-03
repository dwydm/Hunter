package Cwiczenia.Wzorce.Factory.Units;

import Cwiczenia.Wzorce.Factory.Units.Aliens.Alien;
import Cwiczenia.Wzorce.Factory.Units.Aliens.AlienType;
import Cwiczenia.Wzorce.Factory.Units.Humans.Human;
import Cwiczenia.Wzorce.Factory.Units.Humans.HumanType;

public abstract class UnitFactory {
    public abstract Alien createAlien(AlienType type);
    public abstract Human createHuman(HumanType type);
}
