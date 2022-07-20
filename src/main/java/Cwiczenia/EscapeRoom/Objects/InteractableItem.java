package Cwiczenia.EscapeRoom.Objects;

public abstract class InteractableItem {

    private boolean interactionFlag;
    private boolean shouldBeDisplayed = true;
    private boolean pickupable;

    public abstract String use();

    public boolean getInteractionFlag() {
        return interactionFlag;
    }

    public boolean isPickupable() {
        return pickupable;
    }

    protected void setPickupable(boolean pickupable){
        this.pickupable = pickupable;
    }

    protected void switchInteractionFlag() {
        interactionFlag = !interactionFlag;
    }

    protected void setShouldBeDisplayed(boolean shouldDisplay) {
        shouldBeDisplayed = shouldDisplay;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
