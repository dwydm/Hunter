package Cwiczenia.Wzorce.Strategy;

public class Citizen {
    private int age;
    private double medicineCosts;
    private Discountable discount;

    public Citizen(int age, double medicineCosts){
        this.age = age;
        this.medicineCosts = medicineCosts;

    }

    public void setDiscount(Discountable discount) {
        this.discount = discount;
    }

    public void printMedicineCost(){
        System.out.println(discount.calculatePrice(age));
    }

    public int getAge() {
        return age;
    }

    public double getMedicineCosts() {
        return medicineCosts;
    }
}
