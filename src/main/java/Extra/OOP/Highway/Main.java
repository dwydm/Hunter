package Extra.OOP.Highway;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static Highway autostrada = new Highway();

    public static void main(String[] args) throws IOException {
        BufferedReader rdr = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            System.out.println("Dostępne polecenia:\n-wjazd NR_REJESTRACYJNY TYP_POJAZDU\n-wyjazd NR_REJESTRACYJNY\n-sprawdz NR_REJESTRACYJNY\n-koniec");
            System.out.println();
            String polecenieInp = rdr.readLine();
            if (polecenieInp.equalsIgnoreCase("koniec")) {
                break;
            }
            try {
                realizujPolecenie(polecenieInp);
            }
            catch (IllegalArgumentException e) {
                System.out.println("Niepoprawny typ pojazdu");
            }
        }


    }

    public static void realizujPolecenie(String polecenia) {
        String[] polecenie = polecenia.split(" ",3);

        if(polecenie[0].equalsIgnoreCase("wjazd") && polecenie.length == 3) {
            autostrada.vehicleEntry(polecenie[1].toUpperCase(), CarType.valueOf(polecenie[2]));

        } else if (polecenie[0].equalsIgnoreCase("wyjazd") && polecenie.length == 2) {
            autostrada.vehicleLeave(polecenie[1].toUpperCase());

        } else if (polecenie[0].equalsIgnoreCase("sprawdz") && polecenie.length == 2) {
            autostrada.searchVehicle(polecenie[1].toUpperCase());
        }
        else {
            System.out.println("Wprowadzono niepoprawne dane\n");
        }

    }

}
