package Cwiczenia.EscapeRoom;

import Cwiczenia.EscapeRoom.Objects.Door;
import Cwiczenia.EscapeRoom.Objects.InteractableObject;
import Cwiczenia.EscapeRoom.Objects.Key;
import Cwiczenia.EscapeRoom.Objects.Window;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Room {

    List<InteractableObject> roomObjectList = new ArrayList<InteractableObject>(Arrays.asList(new Window(), new Key(), new Door()));

}
