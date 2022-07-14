package Cwiczenia.EscapeRoom.Objects;

public class Window extends InteractableObject {
    @Override
    public void use() {
        switchInteractionFlag();
    }
}
