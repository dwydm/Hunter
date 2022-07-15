package Cwiczenia.EscapeRoom.Objects;

public class Door extends InteractableItem {

    private Key keyHole;




    @Override
    public void use() {
        switchInteractionFlag();
    }
}
