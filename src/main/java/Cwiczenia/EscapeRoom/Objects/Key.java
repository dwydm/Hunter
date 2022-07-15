package Cwiczenia.EscapeRoom.Objects;

import java.awt.desktop.AppReopenedEvent;

public class Key extends InteractableItem {

    private Door lock;

    @Override
    public void use() {
        if(getInteractionFlag()) {
            return;
        }
        switchInteractionFlag();
        setShouldBeDisplayed(false);
    }
}
