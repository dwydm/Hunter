package Cwiczenia.HotelService.Hotel;

import Cwiczenia.HotelService.Guest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Room {
    private int guestCapacity;
    private List<Guest> guestList = new ArrayList<>(guestCapacity);
    private int roomNumber;
    private boolean hasBathroom;
    private boolean isOccupied;
    private boolean isClean;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;

    public Room(int roomNumber, int guestCapacity, boolean hasBathroom, boolean isOccupied) {   //konstruktor do zainicjalizowania stanu początkowego
        this.roomNumber = roomNumber;
        this.guestCapacity = guestCapacity;
        this.hasBathroom = hasBathroom;
        this.isOccupied = isOccupied;
        this.checkInDate = LocalDate.now();
        isClean = true;

        String[] defaultNamesArray = {"Bob", "Kate", "George", "Baldrick", "Edmund", "Steve", "Agatha", "John"};
        String[] rdefaultSurnamesArray = {"Melchett", "Adder", "Darling", "Mond", "Weiland", "Curtis"};

        if (isOccupied) {
            Random rnd = new Random();
            LocalDate randomBDate = LocalDate.of(1922, 1, 1);
            for (int i = 0; i < guestCapacity; i++) {
                int randomName = rnd.nextInt(defaultNamesArray.length);
                int randomSurname = rnd.nextInt(rdefaultSurnamesArray.length);

                randomBDate = randomBDate.plusYears(rnd.nextInt(91) + 1).plusMonths(rnd.nextInt(12));
                randomBDate = randomBDate.plusDays(rnd.nextInt(31));

                checkOutDate = checkInDate.plusDays(rnd.nextInt(8) + 1);

                guestList.add(new Guest(defaultNamesArray[randomName], rdefaultSurnamesArray[randomSurname], randomBDate));
            }
        }

    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public boolean isClean() {
        return isClean;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public int getGuestCapacity() {
        return guestCapacity;
    }

    protected void setClean() {
        isClean = true;
    }

    protected void checkOutGuests() {
        for (Guest guest : guestList) {
            System.out.println(guest + " checked out: " + LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        }
        guestList.clear();
        checkInDate = null;
        checkOutDate = null;
        isClean = false;
        isOccupied = false;
    }

    protected void checkInGuest(int timePeriod, Guest... guests) {
        checkInDate = LocalDate.now();
        checkOutDate = checkInDate.plusDays(timePeriod);
        for (Guest guest : guests) {
            guestList.add(guest);
            System.out.println(guest + " checked in: " + checkInDate.getDayOfMonth() + " " + checkInDate.getMonth() + " " + checkInDate.getYear());
        }
        isOccupied = true;
    }


    @Override
    public String toString() {
        return "Room " + roomNumber + " status: " + (isOccupied ? "Booked" : "Avaible") +
                "\tGuest capacity: " + guestCapacity +
                "\tBathroom: " + (hasBathroom ? "yes" : "no") +
                (isOccupied ? "\tRegistered guests: " + guestList.size() : "");
    }
}
