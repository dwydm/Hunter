package Cwiczenia.EscapeRoom;

public class EventDirector {


    private Room room = new Room();

    public String displpayInteractableItems() {
        String itemList = "\n";
        for (int i = 0; i < room.getRoomItemList().size(); i++) {
            itemList += "\t" + (i + 1) + ". " + room.getRoomItemList().get(i) + "\n";
        }
        return itemList;
    }

    public void useInteractableItem(String nextLine) throws InteractableItemNotFoundException, NumberFormatException {
            int itemIndex = Integer.parseInt(nextLine) - 1;

        if(itemIndex > room.getRoomItemList().size() || itemIndex < 0) {
            throw new InteractableItemNotFoundException("There is no such item in the room");
        }

    }


}
