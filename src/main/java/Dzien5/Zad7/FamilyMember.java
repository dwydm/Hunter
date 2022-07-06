package Dzien5.Zad7;

public interface FamilyMember {

    default void introduceYourself() {
            System.out.println("I am " + getClass().getSimpleName().toLowerCase());
    }


}
