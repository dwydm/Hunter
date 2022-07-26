package SDAKurs.Dzien9.Task20;

public class EquationDemo {

    public static void main(String[] args) {

        Equation equationAdd = new Equation() {
            @Override
            public int execute(int a, int b) {
                return a + b;
            }
        };

        Equation equationSubtract = new Equation() {
            @Override
            public int execute(int a, int b) {
                return a - b;
            }
        };


        System.out.println(equationAdd.execute(2,3));
        System.out.println(equationSubtract.execute(2,3));




    }

}
