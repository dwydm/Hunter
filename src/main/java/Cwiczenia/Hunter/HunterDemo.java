package Cwiczenia.Hunter;

import Cwiczenia.Hunter.Board.Board;
import Cwiczenia.Hunter.Items.PlayerPiece;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class HunterDemo {
    private static boolean loopMenuAgain = true;

    public static void main(String[] args) {
        hunterMenu();
/*        Hunter hunter = new Hunter();
        Board board = Board.getBoard();

        board.cleanBoard();
        board.displayBoard();
        hunter.printPlayerInstruction();*/

    }

    public static void hunterMenu(){
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter your name");
        String playerName = scn.nextLine();

        do {
            System.out.println("Choose an action");
            System.out.println("N - New Game\nE - Exit Program");
            switch (scn.nextLine().toUpperCase()) {
                case "N":
                    Hunter hunterGame = new Hunter();
                    PlayerPiece playerPiece = new PlayerPiece("" + playerName.toUpperCase().charAt(0));
                    hunterGame.startGame(playerPiece);
                    break;
                case "E":
                    loopMenuAgain = false;
                    break;
                default:
            }

        }while (loopMenuAgain);
    }


/*      //work in progress, zapisywanie wyników do pliku

        private String getReturningPlayer() {
        File saveFile = new File("src/main/java/Cwiczenia/Hunter/Save/Player.hnt");
        if(!saveFile.exists()) {
            try {
                FileWriter fileWriter = new FileWriter("src/main/java/Cwiczenia/Hunter/Save/Players.hnt");
                fileWriter.write("*** SAVE FILE ***",0,0);
            } catch (IOException e) {
                System.out.println("Unable to create a file");
            }
        }
        Scanner scn = new Scanner();

    }*/


}
