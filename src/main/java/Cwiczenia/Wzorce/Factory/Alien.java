package Cwiczenia.Wzorce.Factory;

public abstract class Alien {
    private String rank;
    private int stamina;

    public Alien(String rank, int stamina) {
        this.rank = rank;
        this.stamina = stamina;
    }


    @Override
    public String toString() {
        return "Alien{" +
                "rank='" + rank + '\'' +
                ", stamina=" + stamina +
                '}';
    }
}
