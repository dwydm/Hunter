package Cwiczenia.Citizen;

public abstract class Citizen {
    protected String name;

    public Citizen(String name, boolean canVote) {
        this.name = name;
    }

    public abstract boolean canVote();

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + ": " + getName();
    }
}
