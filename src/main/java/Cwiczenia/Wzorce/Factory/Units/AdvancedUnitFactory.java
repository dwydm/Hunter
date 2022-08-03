package Cwiczenia.Wzorce.Factory.Units;

import Cwiczenia.Wzorce.Factory.Units.Aliens.*;
import Cwiczenia.Wzorce.Factory.Units.Humans.Human;
import Cwiczenia.Wzorce.Factory.Units.Humans.Aquanaut;
import Cwiczenia.Wzorce.Factory.Units.Humans.HumanType;
import Cwiczenia.Wzorce.Factory.Units.Humans.Psi;

public class AdvancedUnitFactory extends UnitFactory {


    @Override
    public Alien createAlien(AlienType alienType) {
        switch (alienType) {
            case AQUATOID:
                return new Aquatoid(80,100,90);
            case GILLMAN:
                return new Gillman(90, 90,110);
            case LOBSTERMAN:
                return new Lobsterman(110,80,90);
            case TASOTH:
                return new Tasoth(100,90,80);
            default:
                return new Aquatoid(70,70,70);
        }
    }

    @Override
    public Human createHuman(HumanType humanType) {
        switch (humanType) {
            case AQUANAUT:
                return new Aquanaut(80,10,90,90);
            case PSI:
                return new Psi(70,0,80,110);
            default:
                return new Aquanaut(70,10,70,70);
        }
    }
}
