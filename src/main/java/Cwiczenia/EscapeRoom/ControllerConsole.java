package Cwiczenia.EscapeRoom;

import Cwiczenia.EscapeRoom.EventDirector;
import Cwiczenia.EscapeRoom.InteractableItemNotFoundException;

import java.util.Scanner;

public class ControllerConsole extends Controller {

    private EventDirector eventDirector = new EventDirector();
    private boolean isMenuLooping = true;

    @Override
    public void displayOnScreen(String message) {
        System.out.println(message);
    }

    @Override
    public String saveUserInput(String message) {
        Scanner scn = new Scanner(System.in);
        System.out.print(message);
        return scn.nextLine();
    }


}
