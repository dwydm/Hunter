package Cwiczenia.HotelService;

import java.util.*;

public class Hotel {
    private static final int ROOMS_NUMBER = 10;
    private final Map<Integer, Room> roomList = new HashMap<>();

    public Hotel() {
        Random rnd = new Random();
        for (int i = 0; i < ROOMS_NUMBER; i++) {
            int numberOfGuests = rnd.nextInt(5) + 1;
            boolean isOccupied = rnd.nextBoolean();
            roomList.put(i + 100, new Room(i + 100, numberOfGuests, rnd.nextBoolean(), isOccupied));
        }

    }

    public Map<Integer, Room> getRoomList() {
        return roomList;
    }

    @Override
    public String toString() {
        return "Hotel status:\nTotal rooms: " + roomList.size() + "\nFree rooms: "; //avaibleRoomList.size();
    }
}
