package Cwiczenia.HotelService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Room {
    private int guestCapacity;
    private List<Guest> guestList = new ArrayList<>(guestCapacity);
    private int roomNumber;
    private boolean hasBathroom;
    private boolean isOccupied;
    private LocalDate checkInDate;
    private LocalDate getCheckOutDate;

    public Room(int roomNumber, int guestCapacity, boolean hasBathroom, boolean isOccupied) {   //konstruktor do zainicjalizowania stanu początkowego
        this.roomNumber = roomNumber;
        this.guestCapacity = guestCapacity;
        this.hasBathroom = hasBathroom;
        this.isOccupied = isOccupied;
        this.checkInDate = LocalDate.now();

        String[] defaultNamesArray = {"Bob", "Kate", "George", "Baldrick", "Edmund", "Steve", "Agatha", "John"};
        String[] rdefaultSurnamesArray = {"Melchett", "Adder", "Darling", "Mond", "Weiland", "Curtis"};

        if(isOccupied) {
            Random rnd = new Random();
            LocalDate randomBDate = LocalDate.of(1922, 1,1);
            for (int i = 0; i < guestCapacity; i++) {
                int randomName = rnd.nextInt(defaultNamesArray.length);
                int randomSurname = rnd.nextInt(rdefaultSurnamesArray.length);

                randomBDate.plusYears(rnd.nextInt(91)+1);
                randomBDate.plusMonths(rnd.nextInt(12));
                randomBDate.plusDays(rnd.nextInt(31));

                getCheckOutDate = checkInDate.plusDays(rnd.nextInt(8)+1);

                guestList.add(new Guest(defaultNamesArray[randomName], rdefaultSurnamesArray[randomSurname],randomBDate));
            }
        }

    }

    public boolean isOccupied() {
        return isOccupied;
    }


    @Override
    public String toString() {
        return "Room " + roomNumber + " status: " + (isOccupied ? "Booked" : "Avaible") +
                                                "\tGuest capacity: " + guestCapacity +
                                                "\tBathroom: " + (hasBathroom ? "yes" : "no");
    }
}
