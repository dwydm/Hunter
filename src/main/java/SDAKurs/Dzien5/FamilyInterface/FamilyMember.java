package SDAKurs.Dzien5.FamilyInterface;

public interface FamilyMember {

    default void introduceYourself() {
            System.out.println("I am " + getClass().getSimpleName().toLowerCase());
    }


}
