package SDATasks.challenge1;

import java.time.LocalDate;
import java.util.Random;

public class MyPerson extends Person{
    private static Random rnd = new Random();


    public MyPerson(String name) {
        super(name);
    }

    @Override
    protected int getRandomCash() {
        return rnd.nextInt(25_000) + 1;
    }

    @Override
    public LocalDate getRandomBirthDate() {
        return LocalDate.of(rnd.nextInt(80)+1922,rnd.nextInt(11) + 1,rnd.nextInt(28) +1);
    }

    @Override
    public int getAge() {
        return LocalDate.now().getYear() - getBirthDate().getYear();
    }
}
