package Cwiczenia.EscapeRoom.Items;

public abstract class InteractableItem {

    private boolean shouldBeDisplayed;
    private boolean isExamined;
    private boolean isManipulated;
    private boolean isCombined;


    public abstract void use();
    public abstract void initialDescription();

    public String getItemName() {
        return getClass().getSimpleName();
    }
}
