package Cwiczenia.HotelService;

import java.util.Scanner;

import static Cwiczenia.HotelService.UserService.*;

public class HotelServiceDemo {
    public static void main(String[] args) {
        hsStart();


    }

    private static void hsStart() {
        Scanner scn = new Scanner(System.in);
        UserService userService = new UserService();
        boolean loopMenu = true;

        do {
            System.out.println("\nChoose an action");
            System.out.println("1 - Display all hotel rooms\n2 - Display available rooms only\n3 - Rent a room\n4 - Vacate room\n5 - Room service");
            System.out.print("Input: ");
            String userInput = scn.nextLine();
            System.out.println();               //wskazanie użytkownikowi miejsca do wpisania liczby wymagało wyciągnięcia inputu do zmiennnej
            switch (userInput) {                //i wstawienie dodatkowego souta aby się nie rozjeżdzały pozostałe informacje
                case "1":
                    displayAllRooms();
                    break;
                case "2":
                    displpayFreeRoomsOnly();
                    break;
                case "3":
                    bookRoom();
                    break;
                case "4":
                    vacateRoom();
                    break;
                case "5":
                    hotelServiceMenu();
                    break;
                default:
                    loopMenu = false;
            }

        }while(loopMenu);
    }
}
