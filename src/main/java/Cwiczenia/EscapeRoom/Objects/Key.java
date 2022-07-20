package Cwiczenia.EscapeRoom.Objects;

import java.awt.desktop.AppReopenedEvent;

public class Key extends InteractableItem {

    public Key(boolean pickupable) {
        setPickupable(pickupable);
    }

    @Override
    public String use() {
        if(getInteractionFlag()) {
            return "The key has already been taken";
        }
        switchInteractionFlag();
        setShouldBeDisplayed(false);
        return "You pick up old rusty key";
    }
}
