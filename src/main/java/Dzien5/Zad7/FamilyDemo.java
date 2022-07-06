package Dzien5.Zad7;

public class FamilyDemo {
    public static void main(String[] args) {
        FamilyMember father = new Father();
        Mother mother = new Mother();
        Daughter daughter = new Daughter();
        Son son = new Son();

        father.introduceYourself();
        ((FamilyMember) mother).introduceYourself();
        daughter.introduceYourself();
        son.introduceYourself();

    }
}
