package Cwiczenia.Wzorce.Factory.Units.Humans;

public class Aquanaut extends Human {

    public Aquanaut(int hitPoints, int armor, int timeUnits, int attackPower) {
        super(HumanType.AQUANAUT, hitPoints, armor, timeUnits, attackPower);
    }
}
