package Cwiczenia.EscapeRoom.Objects;

public class Window extends InteractableItem {
    @Override
    public String use() {
        if(getInteractionFlag()) {
            switchInteractionFlag();
            return "You shut the window";
        } else {
            switchInteractionFlag();
            return "You open the window";
        }
    }
}
