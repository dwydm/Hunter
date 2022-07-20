package Cwiczenia.EscapeRoom;

import Cwiczenia.EscapeRoom.Objects.Door;
import Cwiczenia.EscapeRoom.Objects.InteractableItem;
import Cwiczenia.EscapeRoom.Objects.Key;
import Cwiczenia.EscapeRoom.Objects.Window;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Room {

    private List<InteractableItem> roomItemList = new ArrayList<InteractableItem>(Arrays.asList(new Window(), new Key(true), new Door()));
    private InteractableItem pickedUpItem;


    public List<InteractableItem> getRoomItemList() {
        return roomItemList;
    }


    public InteractableItem getPickedUpItem() {
        return pickedUpItem;
    }

    public void setPickedUpItem(InteractableItem pickedUpItem) {
        this.pickedUpItem = pickedUpItem;
    }
}
