package Extra.OOP.Zad2;

public class Person {
    private String name;
    private String adress;

    Person () {
        name = "";
        adress = "";
    }

    Person (String name, String adress) {
        this.name = name;
        this.adress = adress;
    }

    public String getName() {
        return name;
    }

    public String getAdress() {
        return adress;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAdress(String adress) {
        this.adress = adress;
        var some = 1;
    }

    @Override
    public String toString() {
        return "name -> " + name + "\nadress -> " + adress;
    }
}
