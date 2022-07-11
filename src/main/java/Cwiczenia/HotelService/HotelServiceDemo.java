package Cwiczenia.HotelService;

import java.util.Scanner;

public class HotelServiceDemo {
    public static void main(String[] args) {
        //hsStart();


    }

    private static void hsStart() {
        Scanner scn = new Scanner(System.in);
        UserService userService = new UserService();
        boolean loopMenu = true;

        do {
            System.out.println("Choose an action");
            System.out.println("1 - Display all hotel rooms\n2 - Display avaible rooms only\n3 - Book a room\n4 - Check out");
            switch (scn.nextLine()) {
                case "1":   //lista pokoi
                    userService.displayAllRooms();
                    break;
                case "2":   //lista wolnych pokoi
                    userService.displpayFreeRoomsOnly();
                    break;
                case "3":   //rezerwacja pokoju
                    break;
                case "4":   //zwolnienie pokoju
                    break;
                default:
                    loopMenu = false;
            }

        }while(loopMenu);
    }
}
