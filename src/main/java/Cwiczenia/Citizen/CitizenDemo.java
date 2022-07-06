package Cwiczenia.Citizen;

import Cwiczenia.Citizen.Citizens.King;
import Cwiczenia.Citizen.Citizens.Peasant;
import Cwiczenia.Citizen.Citizens.Soldier;
import Cwiczenia.Citizen.Citizens.Townsman;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CitizenDemo {

    public static void main(String[] args) {

        Town town = fillTownWithCitizens();
        System.out.println(howManyCanVote(town.getCitizens()));
        printWhoCanVote(town.getCitizens());

    }

    public static int howManyCanVote(List<Citizen> citizenList) {
        int howManyCanVote = 0;
        for(Citizen citizen : citizenList) {
            if (citizen.canVote()) {
                howManyCanVote++;
            }
        }
        return howManyCanVote;

    }

    public static void printWhoCanVote(List<Citizen> citizenList) {
        for (Citizen citizen : citizenList) {
            if (citizen.canVote()){
                System.out.println(citizen + " can vote");
            }
        }

    }

    public static Town fillTownWithCitizens() {
        Citizen[] citizenArray =  {new Townsman("Roger", true), new Peasant("Baldrick", false),
                new Townsman("Edmund",true), new King("George", false),new Soldier("Bob", true),
                new Townsman("Kate",true),new Peasant("Chester", false),new Townsman("Brian",true)};

        return new Town(new ArrayList<>(Arrays.asList(citizenArray)));

    }
}
