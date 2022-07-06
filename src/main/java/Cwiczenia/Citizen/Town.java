package Cwiczenia.Citizen;

import Cwiczenia.Citizen.Citizens.King;
import Cwiczenia.Citizen.Citizens.Peasant;
import Cwiczenia.Citizen.Citizens.Soldier;
import Cwiczenia.Citizen.Citizens.Townsman;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;

public class Town {

    private List<Citizen> citizens;

    public Town(List<Citizen> citizens) {
        this.citizens = citizens;
    }

    public List<Citizen> getCitizens() {
        return citizens;
    }


}
