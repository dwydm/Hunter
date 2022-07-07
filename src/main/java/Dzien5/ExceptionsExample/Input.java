package Dzien5.ExceptionsExample;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {

    public int readNumber(){ // lepsze rozwiązanie przez rekurencję
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static void main(String[] args) {
        Input input = new Input();
        int number;
        do {
            try {
                number = input.readNumber();
                break;
            } catch (InputMismatchException e){
                System.out.println("Error: " + e.getClass().getSimpleName() +"\nProvided number is not a number");
            }
        } while (true);
        System.out.println("Podano " + number);
    }
}
