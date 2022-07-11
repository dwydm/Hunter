package Cwiczenia.HotelService;

public class UserService {

    private Hotel hotel = new Hotel();



    public void bookRoom(){



    }

    public void vacateRoom(){

    }

    public void displayAllRooms() {
        System.out.println("\t\t\t\t\t\tHotel rooms:");
        for (Room room : hotel.getRoomList().values()) {
            System.out.println("| " + room + "\t|");
        }
    }

    public void displpayFreeRoomsOnly() {
        System.out.println("\t\t\t\t\t\tRooms avaible for rental:");
        for (Room room : hotel.getRoomList().values()) {
            if(!room.isOccupied()) {
                System.out.println("| " + room + "\t|");
            }
        }
    }
}
