package Cwiczenia.Citizen.Citizens;

import Cwiczenia.Citizen.Citizen;

public class Peasant extends Citizen {

    public Peasant(String name, boolean canVote) {
        super(name, canVote);
    }

    @Override
    public boolean canVote() {
        return false;
    }
}
