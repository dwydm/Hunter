package Cwiczenia.EscapeRoom.Objects;

import Cwiczenia.EscapeRoom.InteractableItemNotFoundException;

public class Door extends InteractableItem {

    private Key key;
    private boolean isUnlocked;


    @Override
    public String use() {
        if (key == null) {
            return "The door is locked";
        }
        switchInteractionFlag();

         if (getInteractionFlag()) {
             return "You open the door";
         } else {
             return "You close the door";
         }
    }

    public String unlockDoor(Key key) {
        this.key = key;
        isUnlocked = true;
        return "Sound of the key grinding in the lock, spreads across the room, the door is unlocked now";
    }

    public boolean isUnlocked() {
        return isUnlocked;
    }
}
