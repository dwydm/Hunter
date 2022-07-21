package Cwiczenia.EscapeRoom;

import Cwiczenia.EscapeRoom.Objects.*;

public class EventDirector {


    private Room room = new Room();

    public String getRoomInteractableItems() {
        String itemList = "\n";
        for (int i = 0; i < room.getRoomItemList().size(); i++) {
            itemList += "\t" + (i + 1) + ". " + room.getRoomItemList().get(i) + "\n";
        }
        itemList += "\t0. Exit program\n";
        return itemList;
    }

    public int inputValidator(String userInput) throws InteractableItemNotFoundException, NumberFormatException {
        int itemIndex = Integer.parseInt(userInput) - 1;

        if (itemIndex >= room.getRoomItemList().size() || itemIndex < -1) {
            throw new InteractableItemNotFoundException("There is no such item in the room");
        }
        return itemIndex;
    }

    public String useInteractableItem(int itemIndex) {
        InteractableItem currentItem = room.getRoomItemList().get(itemIndex);

        if (room.getPickedUpItem() != null && currentItem instanceof Door && !((Door) currentItem).isUnlocked()) {
            return ((Door) currentItem).unlockDoor((Key)room.getPickedUpItem());
        }

        if (currentItem.isPickupable()) {
            room.setPickedUpItem(currentItem);
            room.getRoomItemList().remove(currentItem);
        }

        return currentItem.use();
    }


}
