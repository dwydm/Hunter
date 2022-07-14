package Cwiczenia.EscapeRoom.Objects;

public abstract class InteractableObject {

    private boolean interactionFlag;
    private boolean shouldBeDisplayed = true;

    public abstract void use();

    public boolean getInteractionFlag() {
        return interactionFlag;
    }

    protected void switchInteractionFlag() {
        interactionFlag = !interactionFlag;
    }

    protected void setShouldBeDisplayed(boolean shouldDisplay) {
        shouldBeDisplayed = shouldDisplay;
    }



}
