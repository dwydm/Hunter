package Cwiczenia.Wzorce.Strategy;

public class CitizenDemo {
    public static void main(String[] args) {

        Citizen citizen1 = new Citizen(55, 178);
        Citizen citizen2 = new Citizen(87, 300);
        citizen1.setDiscount(new Receipt());
        citizen2.setDiscount(new DiscountedReceipt());


        citizen1.printMedicineCost();
        citizen2.printMedicineCost();

    }
}
