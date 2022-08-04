package SDATasks.Zad23;

import java.util.Comparator;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Operations23 {
    public static void main(String[] args) {

        //a
        Supplier randomNum = () -> {
            Random rnd = new Random();
            return rnd.nextInt(10) + 1;
        };
        System.out.println(randomNum.get());

        //b
        String pwd = "c47ac";

        Predicate isPasswordValid = password -> String.valueOf(password).length() >= 5;
        System.out.println(isPasswordValid.test(pwd));

        //c
        Comparator compareLength = (text1, text2) -> {
            if(String.valueOf(text1).length() > String.valueOf(text2).length()) {
                return 1;
            } else if (String.valueOf(text1).length() < String.valueOf(text2).length()) {
                return -1;
            } else {
                return 0;
            }
        };

        System.out.println(compareLength.compare("kot", "ok"));


    }
}
