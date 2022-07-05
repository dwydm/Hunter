package Cwiczenia.Citizen;

public abstract class Citizen {
    protected String name;
    protected boolean canVote;

    public Citizen(String name, boolean canVote) {
        this.name = name;
        this.canVote = canVote;
    }

    public String getName() {
        return name;
    }

    public boolean canVote() {
        return canVote;
    }
}
