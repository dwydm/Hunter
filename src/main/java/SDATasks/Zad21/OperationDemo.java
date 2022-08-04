package SDATasks.Zad21;

public class OperationDemo {
    public static void main(String[] args) {
        Operation addition = new Operation() {
            @Override
            public int process(int num1, int num2) {
                return num1 + num2;
            }
        };

        System.out.println(addition.process(7, 14));

        Operation subtraction = (numberOne, numberTwo) -> numberOne - numberTwo;

        System.out.println(subtraction.process(7,14));


    }
}
