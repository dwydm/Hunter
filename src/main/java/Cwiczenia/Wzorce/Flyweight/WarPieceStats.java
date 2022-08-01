package Cwiczenia.Wzorce.Flyweight;

public class WarPieceStats {
    private int hp;
    private int armor;
    private int speed;
    private int cost;

    public WarPieceStats(int hp, int armor, int speed, int cost) {
        this.hp = hp;
        this.armor = armor;
        this.speed = speed;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return  "hp=" + hp +
                ", armor=" + armor +
                ", speed=" + speed +
                ", cost=" + cost +
                '}';
    }
}
