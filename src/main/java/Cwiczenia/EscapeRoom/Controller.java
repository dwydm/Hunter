package Cwiczenia.EscapeRoom;

import java.util.Scanner;

public abstract class Controller {

    private EventDirector eventDirector = new EventDirector();
    private boolean isMenuLooping = true;

    public void startGame() {

        displayOnScreen("""
                Let's play a game
                You're in a dim lit room
                Fortunately you're able to see some familiar shapes of particular objects
                """);
        do {
            displayOnScreen(eventDirector.getRoomInteractableItems());
            try {
                int userInput = eventDirector.inputValidator(saveUserInput("Use an item: "));
                if(userInput < 0 ) {
                    isMenuLooping = false;
                } else {
                    String outputMessage = eventDirector.useInteractableItem(userInput);
                    displayOnScreen(outputMessage);
                }
            } catch (InteractableItemNotFoundException e) {
                displayOnScreen("\n" + e.getMessage());
            } catch (NumberFormatException e) {
                displayOnScreen("\n" + "Invalid input");
            }

        } while(isMenuLooping);
    }

    public abstract void displayOnScreen(String message);
    public abstract String saveUserInput(String message);


}
