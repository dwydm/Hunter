package Cwiczenia.Citizen.Citizens;

import Cwiczenia.Citizen.Citizen;

public class King extends Citizen {

    public King(String name, boolean canVote) {
        super(name, canVote);
    }

    @Override
    public boolean canVote() {
        return false;
    }
}
