package Cwiczenia.Wzorce.Strategy;

public class DiscountedReceipt implements Discountable{
    @Override
    public double calculatePrice(int age) {
        return 0;
    }


/*    @Override
    public double calculatePrice(int age) {
        return citizen.getMedicineCosts() - (citizen.getMedicineCosts() * 0.1);
    }*/
}
