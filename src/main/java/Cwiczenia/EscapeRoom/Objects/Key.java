package Cwiczenia.EscapeRoom.Objects;

public class Key extends InteractableObject {

    @Override
    public void use() {
        if(getInteractionFlag()) {
            return;
        }
        switchInteractionFlag();
        setShouldBeDisplayed(false);
    }
}
