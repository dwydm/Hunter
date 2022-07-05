package Cwiczenia.Citizen;

import Cwiczenia.Citizen.Citizens.King;
import Cwiczenia.Citizen.Citizens.Peasant;
import Cwiczenia.Citizen.Citizens.Soldier;
import Cwiczenia.Citizen.Citizens.Townsman;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Town {

    private static List<Citizen> citizens;

    public static void main(String[] args) {

        fillTownWithCitozens();

        System.out.println(howManyCanVote());
        whoCanVote();

    }

    public static int howManyCanVote() {
        int howManyCanVote = 0;
        for (Citizen citizen : citizens) {
            if(citizen.canVote()) {
                howManyCanVote++;
            }
        }
        return howManyCanVote;

    }

    public static void whoCanVote() {
        for(Citizen citizen : citizens) {
            if(citizen instanceof Townsman || citizen instanceof Soldier) {
                System.out.println(citizen.getClass().getSimpleName() + ": " + citizen.getName());
            }
        }

    }

    public static void fillTownWithCitozens() {
        Citizen[] citizenArray =  {new Townsman("Roger", true), new Peasant("Baldrick", false),
                new Townsman("Edmund",true), new King("George", false),new Soldier("Bob", true),
                new Townsman("Kate",true),new Peasant("Chester", false),new Townsman("Brian",true)};

        citizens = new ArrayList<>(Arrays.asList(citizenArray));

    }
}
