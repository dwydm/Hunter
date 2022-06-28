package Dzien2.ProjektDom;

public class Dom {
    private Pokoj[] pokoje;

    public Dom(Pokoj...pokoje) {
        this.pokoje = pokoje;
    }

    public Pokoj getPokoj(int numerPokoju) {
        if(numerPokoju >= pokoje.length || numerPokoju < 0) {
            System.out.println("Nie ma takiego pokoju");
            return null;
        } else {
            return pokoje[numerPokoju];

        }
    }

    @Override
    public String toString() {
        String details = "";
        for(Pokoj pokoj : pokoje) {
            details += pokoj.toString() + "\n";
        }

        return details;
    }
}
