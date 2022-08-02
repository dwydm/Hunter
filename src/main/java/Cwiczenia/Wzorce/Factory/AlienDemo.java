package Cwiczenia.Wzorce.Factory;

public class AlienDemo {
    public static void main(String[] args) {
        UnitFactory basic = new BasicUnitFactory();
        UnitFactory advanced = new AdvancedUnitFactory();

        System.out.println(basic.createHuman("marine"));
        basic.createAlien("muton");

        advanced.createHuman("psi");
        advanced.createAlien("muton");
        advanced.createAlien("sectoid");

    }
}
