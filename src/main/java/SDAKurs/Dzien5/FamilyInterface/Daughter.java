package SDAKurs.Dzien5.FamilyInterface;

public class Daughter implements FamilyMember {
    @Override
    public void introduceYourself() {
        System.out.println("I am " + getClass().getSimpleName().toLowerCase());
    }
}
