package Cwiczenia.Wzorce.Factory.Units.Aliens;

public abstract class Alien {

    private AlienType type;
    private int hitPoints;
    private int timeUnits;
    private int attackPower;


    protected Alien(AlienType type, int hitPoints, int timeUnits, int attackPower) {
        this.type = type;
        this.hitPoints = hitPoints;
        this.timeUnits = timeUnits;
        this.attackPower = attackPower;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public int getTimeUnits() {
        return timeUnits;
    }

    public int getAttackPower() {
        return attackPower;
    }

    @Override
    public String toString() {
        return "Alien: " + type + " HP: " + hitPoints + " ATT: " + attackPower + " TU: " + timeUnits;
    }
}
