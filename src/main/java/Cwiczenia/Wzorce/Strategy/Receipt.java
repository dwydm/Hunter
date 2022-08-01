package Cwiczenia.Wzorce.Strategy;

public class Receipt implements Discountable{
/*    @Override
    public double calculatePrice(Citizen citizen) {
        return citizen.getMedicineCosts();
    }*/

    @Override
    public double calculatePrice(int age) {
        return 0;
    }
}
