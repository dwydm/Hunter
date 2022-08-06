package Cwiczenia.Wzorce.Factory;

import Cwiczenia.Wzorce.Factory.Units.AdvancedUnitFactory;
import Cwiczenia.Wzorce.Factory.Units.Aliens.Alien;
import Cwiczenia.Wzorce.Factory.Units.BasicUnitFactory;
import Cwiczenia.Wzorce.Factory.Units.Humans.Human;
import Cwiczenia.Wzorce.Factory.Units.UnitFactory;

import java.util.List;
import java.util.Scanner;

public class AlienFactoryDemo {
    private static List<Alien> aliens;
    private static List<Human> humans;
    public static void main(String[] args) {

        startMenu();
    }

    private static void startMenu() {
        Scanner scn = new Scanner(System.in);
        do {
            System.out.println("1 - Create Random Alien Team\n2 - Create Random Human Team\n3 - Start Battle");
            switch (scn.nextLine()) {
                case "1":
                    aliens = ArmyBuilder.buildAlienArmy();
                    System.out.println("Alien team size: " + aliens.size());
                    break;
                case "2":
                    humans = ArmyBuilder.buildHumanArmy();
                    System.out.println("Human team size: " + humans.size());
                    break;
                case "3":
                    startBattle();
                    break;
                default:
                    return;
            }
        } while (true);
    }

    private static void startBattle(){
        int smallerArmyCount = Math.min(humans.size(), aliens.size());
        boolean areBothArmiesAlive = true;

        do {
            //porównanie pierwszych jednostek
            //oddawanie strzału
            //usuwanie martwych jednostek z listy

            if(humans.size() == 0) {
                System.out.println("Aliens are victorious");
                areBothArmiesAlive = false;
            } else if(aliens.size() == 0) {
                System.out.println("Humans are victorious");
                areBothArmiesAlive = false;
            }
        }while (areBothArmiesAlive);


    }
}
