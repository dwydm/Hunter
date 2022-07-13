package Cwiczenia.EscapeRoom;

import Cwiczenia.EscapeRoom.Items.InteractableItem;

import java.util.ArrayList;
import java.util.List;

public class Room {

    private List<InteractableItem> roomObjects = new ArrayList<>();
    private InteractableItem playersFocus;



    public void roomIntroduction() {
        System.out.println("You're in a corner of a dim lit room");
        System.out.println("There is complete silence\n");
    }

    public InteractableItem getPlayersFocus() {
        return playersFocus;
    }

    public String availibleItems() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < roomObjects.size(); i++) {
            sb.append(i + ". ").append(roomObjects.get(i).getItemName()).append(" ");
        }
        return sb.toString();
    }

}
