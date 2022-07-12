package Cwiczenia.HotelService.Hotel;

import Cwiczenia.HotelService.Guest;

import java.util.*;

public class Hotel {
    private static Hotel hotel;
    private static final int ROOMS_NUMBER = 10;
    private static final int MAX_GUEST_CAPACITY = 4;
    private final Map<Integer, Room> roomMap = new HashMap<>();

    private Hotel() {
        Random rnd = new Random();
        for (int i = 0; i < ROOMS_NUMBER; i++) {
            int numberOfGuests = rnd.nextInt(MAX_GUEST_CAPACITY) + 1;
            boolean isOccupied = rnd.nextBoolean();
            roomMap.put(i + 100, new Room(i + 100, numberOfGuests, rnd.nextBoolean(), isOccupied));
        }

    }

    public static Hotel getHotel() {
        if(hotel == null) {
            hotel = new Hotel();
        }
        return hotel;
    }

    public void rentARoom(int roomNumber, int days, Guest... guests){
        if (roomMap.get(roomNumber).isOccupied()) {
            System.out.println("This room already has been rented");
            return;
        }
        else if(!roomMap.get(roomNumber).isClean()) {
            System.out.println("Sorry, this room needs to be cleaned first");
            return;
        }
        roomMap.get(roomNumber).checkInGuest(days,guests);
    }

    public void vacateTheRoom(int roomNumber){
        if(!roomMap.get(roomNumber).isOccupied()) {
            System.out.println("Vacating this room would give negative number of guests");
            return;
        }
        roomMap.get(roomNumber).checkOutGuests();

    }

    public Map<Integer, Room> getRoomMap() {
        return roomMap;
    }

    @Override
    public String toString() {
        return "Hotel status:\nTotal rooms: " + roomMap.size();
    }


    public void cleanRoom(Room room) {
        room.setClean();
    }
}
