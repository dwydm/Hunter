package SDAKurs.Dzien11.Funkcyjne;

public class Functions {
    public static void main(String[] args) {

        Equation addition = new Equation() {
            @Override
            public double evaluate(double number1, double number2) {
                return number1 + number2;
            }
        };

        System.out.println(addition.evaluate(10, 20));


        Equation subtraction = (a,b) -> a - b;

    }
}

interface Equation {
    double evaluate(double number1, double number2);
}