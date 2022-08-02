package Cwiczenia.Wzorce.Factory;

public abstract class Human {
    private int armor;
    private int stamina;

    public Human(int armor, int stamina) {
        this.armor = armor;
        this.stamina = stamina;
    }

    @Override
    public String toString() {
        return "Human{" +
                "armor=" + armor +
                ", stamina=" + stamina +
                '}';
    }
}
