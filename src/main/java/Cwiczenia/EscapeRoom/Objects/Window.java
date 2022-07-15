package Cwiczenia.EscapeRoom.Objects;

public class Window extends InteractableItem {
    @Override
    public void use() {
        switchInteractionFlag();
    }
}
