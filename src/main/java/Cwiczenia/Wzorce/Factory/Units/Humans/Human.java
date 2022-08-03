package Cwiczenia.Wzorce.Factory.Units.Humans;

public abstract class Human {

    private HumanType type;
    private int hitPoints;
    private int armor;
    private int timeUnits;
    private int attackPower;

    protected Human(HumanType type, int hitPoints,int armor, int timeUnits, int attackPower) {
        this.type = type;
        this.hitPoints = hitPoints;
        this.armor = armor;
        this.timeUnits = timeUnits;
        this.attackPower = attackPower;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public int getArmor() {
        return armor;
    }

    public int getTimeUnits() {
        return timeUnits;
    }

    public int getAttackPower() {
        return attackPower;
    }

    @Override
    public String toString() {
        return "Human: " + type + " HP: " + hitPoints + " ATT: " + attackPower + " TU: " + timeUnits;
    }
}
