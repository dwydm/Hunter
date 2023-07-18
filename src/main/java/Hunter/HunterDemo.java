package Hunter;

import Hunter.Items.PlayerPiece;

import java.util.Scanner;

public class HunterDemo {
    private static boolean loopMenuAgain = true;

    public static void main(String[] args) {
        hunterMenu();

    }

    public static void hunterMenu() {
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

        } while (loopMenuAgain);
    }


}
