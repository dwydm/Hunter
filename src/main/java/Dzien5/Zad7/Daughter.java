package Dzien5.Zad7;

public class Daughter implements FamilyMember {
    @Override
    public void introduceYourself() {
        System.out.println("I am " + getClass().getSimpleName().toLowerCase());
    }
}
