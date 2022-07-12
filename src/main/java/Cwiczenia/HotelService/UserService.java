package Cwiczenia.HotelService;

import Cwiczenia.HotelService.Hotel.Hotel;
import Cwiczenia.HotelService.Hotel.Room;

import javax.swing.text.DateFormatter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class UserService {

    private static Hotel hotel = Hotel.getHotel();

    public static void hotelServiceMenu() {
        Scanner scn = new Scanner(System.in);
        boolean loopMenu = true;
        do {
            System.out.println("\nR - Display rooms for the cleaning\nC - to clean all rooms)\n" +
                    "X - Show previous menu");
            System.out.print("Input: ");
            String userInput = scn.nextLine().toUpperCase();
            System.out.println();
            switch (userInput) {
                case "R":
                    displayRoomsToClean();
                    break;
                case "C":
                    cleanAllRooms();
                    break;
                default:
                    loopMenu = false;
            }
        } while (loopMenu);
    }


    public static void bookRoom() {
        Scanner scn = new Scanner(System.in);
        System.out.println("Which room you would like to rent?");
        String userRoomNumberInput = scn.nextLine();

        if(!validateRoomNumber(userRoomNumberInput)) {
            return;
        }
        int roomNumber = Integer.parseInt(userRoomNumberInput);
        System.out.println("How many people to check in?");
        int numberOfPeople = Integer.parseInt(scn.nextLine());

        if(numberOfPeople > hotel.getRoomMap().get(roomNumber).getGuestCapacity()) {
            System.out.println("Your number of guests exceeds room capacity, pick another room");
            return;
        } else if(numberOfPeople <= 0) {
            System.out.println("There must be at least one person willing to sleep here");
        }
        Guest[] guests = createGuestList(numberOfPeople);

        if(guests == null) {
            return;
        }
        System.out.println("How many days you would like to stay?");
        int days = Integer.parseInt(scn.nextLine());
        hotel.rentARoom(roomNumber,days,guests);
    }

    public static void vacateRoom() {
        Scanner scn = new Scanner(System.in);
        System.out.println("Which room you want to vacate?");
        String roomNumber = scn.nextLine();
        if(!validateRoomNumber(roomNumber)) {
            return;
        }
        hotel.vacateTheRoom(Integer.parseInt(roomNumber));

    }

    private static Guest[] createGuestList(int numberOfPeople) {
        Scanner scn = new Scanner(System.in);
        Guest[] guests = new Guest[numberOfPeople];
        boolean isAnyAdult = false;
        String name;
        String surname;
        LocalDate birthDate;
        for (int i = 0; i < guests.length; i++) {
            System.out.print("\nName: ");
            name = scn.nextLine();
            System.out.print("\nSurname: ");
            surname = scn.nextLine();
            System.out.println("\nYear(yyyy), Month(MM) and Day(dd), separate with space (yyyy MM dd)");
            System.out.print("Date of birth: ");
            String date = scn.nextLine();
            System.out.println();
            birthDate = LocalDate.parse(date,DateTimeFormatter.ofPattern("yyyy MM dd"));

            if(LocalDate.now().minusYears(18).isAfter(birthDate)) {
                isAnyAdult = true;
            }

            guests[i] = new Guest(name,surname,birthDate);
        }

        if(isAnyAdult) {
            return guests;
        } else {
            System.out.println("Sorry, there must be at least one adult person to rent a room");
            return null;
        }
    }


    private static boolean validateRoomNumber(String roomNumberToValidate){
        if(roomNumberToValidate.isEmpty()) {
            System.out.println("Invalid room number");
            return false;
        }
        int userRoomNumber = Integer.parseInt(roomNumberToValidate);
        if(hotel.getRoomMap().containsKey(userRoomNumber)) {
            return true;
        } else {
            System.out.println("No such room number");
            return false;
        }
    }

    private static void cleanAllRooms() {

        for (Room room : hotel.getRoomMap().values()) {
            if(!room.isClean()) {
                hotel.cleanRoom(room);
            }
        }

    }

    public static void displayAllRooms() {
        System.out.println("\t\t\t\t\t\tHotel rooms:");
        for (Room room : hotel.getRoomMap().values()) {
            System.out.println("| " + room + "\t|");
        }
    }

    public static void displpayFreeRoomsOnly() {
        System.out.println("\t\t\t\t\t\tRooms avaible for rental:");
        for (Room room : hotel.getRoomMap().values()) {
            if (!room.isOccupied()) {
                System.out.println("| " + room + "\t|");
            }
        }
    }

    private static void displayRoomsToClean() {
        System.out.println("\t\t\t\t\t\tRooms to clean:");
        for (Room room : hotel.getRoomMap().values()) {
            if (!room.isClean()) {
                System.out.println("| " + room + "\t|");
            }
        }
    }
}
