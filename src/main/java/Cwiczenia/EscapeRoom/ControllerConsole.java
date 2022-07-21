package Cwiczenia.EscapeRoom;

import Cwiczenia.EscapeRoom.EventDirector;
import Cwiczenia.EscapeRoom.InteractableItemNotFoundException;

import java.util.Scanner;

public class ControllerConsole {

    private EventDirector eventDirector = new EventDirector();
    private boolean isMenuLooping = true;

    public void startGame() {
        System.out.println("Let's play a game");
        System.out.println("You're in a dim lit room");
        System.out.println("Fortunately you're able to see some familiar shapes of particular objects");

        do {
            Scanner scn = new Scanner(System.in);
            System.out.println(eventDirector.getRoomInteractableItems());
            System.out.print("Use an item: ");
            try {
                int userInput = eventDirector.inputValidator(scn.nextLine());
                if(userInput < 0 ) {
                    isMenuLooping = false;
                } else {
                    String outputMessage = eventDirector.useInteractableItem(userInput);
                    System.out.println(outputMessage);
                }
            } catch (InteractableItemNotFoundException e) {
                System.out.println("\n" + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("\n" + "Invalid input");
            }

        } while(isMenuLooping);
    }






}
