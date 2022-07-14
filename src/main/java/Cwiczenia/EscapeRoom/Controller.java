package Cwiczenia.EscapeRoom;

import java.util.Scanner;

public class Controller {

    private EventDirector eventDirector = new EventDirector();
    private boolean isMenuLooping = true;

    public void startGame() {
        System.out.println("Let's play a game");
        System.out.println("You're in a dim lit room");
        System.out.println("Fortunately you're able to see some familiar shapes of particular objects");

        do {
            Scanner scn = new Scanner(System.in);
            System.out.print("Choose an action: ");
            switch(scn.nextLine()) {
                case "1":
                    break;

            }

        } while(isMenuLooping);
    }






}
