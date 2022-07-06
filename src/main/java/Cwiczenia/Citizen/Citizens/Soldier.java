package Cwiczenia.Citizen.Citizens;

import Cwiczenia.Citizen.Citizen;

public class Soldier extends Citizen {

    public Soldier(String name, boolean canVote) {
        super(name, canVote);
    }

    @Override
    public boolean canVote() {
        return true;
    }
}
