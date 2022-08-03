package Cwiczenia.Wzorce.Factory;


import Cwiczenia.Wzorce.Factory.Units.AdvancedUnitFactory;
import Cwiczenia.Wzorce.Factory.Units.Aliens.Alien;
import Cwiczenia.Wzorce.Factory.Units.Aliens.AlienType;
import Cwiczenia.Wzorce.Factory.Units.BasicUnitFactory;
import Cwiczenia.Wzorce.Factory.Units.Humans.Human;
import Cwiczenia.Wzorce.Factory.Units.Humans.HumanType;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ArmyBuilder {
    private static Random rnd = new Random();
    private static BasicUnitFactory basicUnitFactory= new BasicUnitFactory();
    private static AdvancedUnitFactory advancedUnitFactory = new AdvancedUnitFactory();
    private static final int MAX_ALIEN_BASIC_UNITS = 15;
    private static final int MAX_ALIEN_ADVANCED_UNITS = 5;
    private static final int MAX_HUMAN_BASIC_UNITS = 20;
    private static final int MAX_HUMAN_ADVANCED_UNITS = 5;

    public static List<Alien> buildAlienArmy() {
        List<Alien> aliens = new ArrayList<>();
        //basic units
        int totalBasicUnitCount = rnd.nextInt(MAX_ALIEN_BASIC_UNITS) + 1;
        AlienType[] alienTypes = AlienType.values();
        for (int i = 0; i < totalBasicUnitCount; i++) {
            aliens.add(basicUnitFactory.createAlien(alienTypes[rnd.nextInt(alienTypes.length)]));
        }

        //advanced units
        int totalAdvancedUnitCount = rnd.nextInt(MAX_ALIEN_ADVANCED_UNITS) + 1;
        for (int i = 0; i < totalAdvancedUnitCount; i++) {
            aliens.add(advancedUnitFactory.createAlien(alienTypes[rnd.nextInt(alienTypes.length)]));
        }
        return aliens;
    }

    public static List<Human> buildHumanArmy() {
        List<Human> humans = new ArrayList<>();
        //basic units
        int totalBasicUnitCount = rnd.nextInt(MAX_HUMAN_BASIC_UNITS) + 1;
        HumanType[] humanTypes = HumanType.values();
        for (int i = 0; i < totalBasicUnitCount; i++) {
            humans.add(basicUnitFactory.createHuman(humanTypes[rnd.nextInt(humanTypes.length)]));
        }

        //advanced units
        int totalAdvancedUnitCount = rnd.nextInt(MAX_ALIEN_ADVANCED_UNITS) + 1;
        for (int i = 0; i < totalAdvancedUnitCount; i++) {
            humans.add(advancedUnitFactory.createHuman(humanTypes[rnd.nextInt(humanTypes.length)]));
        }
        return humans;
    }





}
