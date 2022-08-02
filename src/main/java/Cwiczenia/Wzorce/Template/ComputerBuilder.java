package Cwiczenia.Wzorce.Template;

import java.util.HashMap;
import java.util.Map;

public abstract class ComputerBuilder {
    protected Map<Part,Type> elements = new HashMap<>();

    public Computer build() {
        addPowerSupply();
        addProcessor();
        addMotherboard();
        addRam();
        return new Computer(); //TODO: dokończyć
    }

    protected void addPowerSupply() {
        System.out.println("Power supply added");
    }

     protected abstract void addMotherboard();

     protected abstract void addProcessor();

    protected abstract void addRam();


}
