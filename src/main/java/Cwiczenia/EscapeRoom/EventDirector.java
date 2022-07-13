package Cwiczenia.EscapeRoom;

import Cwiczenia.EscapeRoom.Items.InteractableItem;

public class EventDirector {

    private Room room;

    public EventDirector() {
        room = buildNewRoom();
    }

    private static Room buildNewRoom(){
        return new Room();
    }

    public Room getRoom() {
        return room;
    }

    public InteractableItem playerFocus(){
        return room.getPlayersFocus();
    }

    public String itemList() {
        return room.availibleItems();
    }

}
