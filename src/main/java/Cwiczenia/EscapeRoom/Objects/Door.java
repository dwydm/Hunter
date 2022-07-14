package Cwiczenia.EscapeRoom.Objects;

public class Door extends InteractableObject {

    private Key keyHole;




    @Override
    public void use() {
        switchInteractionFlag();
    }
}
