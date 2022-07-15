package Cwiczenia.EscapeRoom;

import Cwiczenia.EscapeRoom.Objects.Door;
import Cwiczenia.EscapeRoom.Objects.InteractableItem;
import Cwiczenia.EscapeRoom.Objects.Key;
import Cwiczenia.EscapeRoom.Objects.Window;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Room {

    List<InteractableItem> roomItemList = new ArrayList<InteractableItem>(Arrays.asList(new Window(), new Key(), new Door()));


    public List<InteractableItem> getRoomItemList() {
        return roomItemList;
    }

}
