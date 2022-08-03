package Cwiczenia.Wzorce.Factory.Units.Humans;

public class Psi extends Human{

    public Psi(int hitPoints, int armor, int timeUnits, int attackPower) {
        super(HumanType.PSI, hitPoints, armor, timeUnits, attackPower);
    }
}
