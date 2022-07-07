package Dzien5.Zad9Exceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ExceptionsDemo {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        //ma obsłużyć nullPointerException
        String nulledString = null;
        try {
            nulledString.toLowerCase();
            System.out.println();
        } catch (NullPointerException e) {
            System.out.println(e.getClass().getSimpleName());
        }

        //ma obsłużyć wyjątek pojawiający się przy podaniu innej wartości niż liczba
        try{
            int num = scn.nextInt();
        } catch (InputMismatchException e) {
            System.out.println(e.getClass().getSimpleName());
        }

        //ma obsłużyć wyjątek, gdy nie znajdzie pliku
        //rozbudowa: dodatkowa klasa FileConnection oraz własny wyjątek
        FileConnection fileConnection = new FileConnection();
        File file = new File("src/main/java/Dzien5/Zad9Exceptions/books.txt");
        try {
            List<String> fileContent = fileConnection.mapFileContent(file);
            displayContentOfBooksFile(fileContent);
        }catch (FileNotFoundException e) {
            System.out.println("You should read some books then");
        } catch (FileConnectionException e) {
            System.out.println(e.getMessage());
        }



    }

        private static void displayContentOfBooksFile(List<String> fileContent) {

            for (String line : fileContent) {
                System.out.println(line);
            }

        }


}
