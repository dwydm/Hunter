package Dzien5.ExceptionsExample;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {

    public int readNumber(){
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
                System.out.println("Provided number is not a number");
                e.getMessage();
            }
        } while (true);
        System.out.println("Podano " + number);
    }
}
