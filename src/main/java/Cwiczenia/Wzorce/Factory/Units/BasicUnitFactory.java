package Cwiczenia.Wzorce.Factory.Units;

import Cwiczenia.Wzorce.Factory.Units.Aliens.*;
import Cwiczenia.Wzorce.Factory.Units.Humans.Human;
import Cwiczenia.Wzorce.Factory.Units.Humans.Aquanaut;
import Cwiczenia.Wzorce.Factory.Units.Humans.HumanType;

public class BasicUnitFactory extends UnitFactory {
    @Override
    public Alien createAlien(AlienType type) {
        switch (type) {
            case AQUATOID:
                return new Aquatoid(60,80,70);
            case GILLMAN:
                return new Gillman(70, 70,90);
            case LOBSTERMAN:
                return new Lobsterman(90,60,70);
            case TASOTH:
                return new Tasoth(80,70,60);
            default:
                return new Aquatoid(50,50,50);
        }
    }

    @Override
    public Human createHuman(HumanType humanType) {
        switch (humanType) {
            case AQUANAUT:
                return new Aquanaut(50,0,60,60);
            default:
                return new Aquanaut(50,0,50,50);
        }
    }
}
