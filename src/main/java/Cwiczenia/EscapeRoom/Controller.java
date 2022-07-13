package Cwiczenia.EscapeRoom;

import java.util.Scanner;

public class Controller {

    private EventDirector eventDirector = new EventDirector();
    private boolean shouldLoop = true;


    public void menuStarter() {
        System.out.println("Let's play a simple game\n");
        eventDirector.getRoom().roomIntroduction();

        do {
            if(eventDirector.playerFocus() != null) {
                System.out.println(itemDialogFocus());
                itemDetailedMenu(userInput());
            } else {
                System.out.println(roomDialogFocus());
                roomDetailedMenu(userInput());
            }
/*            System.out.println((eventDirector.playerFocus() == null) ? "" : "You are focused on: " + eventDirector.playerFocus());
            System.out.println("What you would like to do next?");
            System.out.println("1 - Look " + ((eventDirector.playerFocus() == null) ? "around the Room" : "at the " + eventDirector.playerFocus().getClass()) +"\n" +
                                "2 - Touch " + ((eventDirector.playerFocus() == null) ? ) );*/

        }while (shouldLoop);

    }

    private void roomDetailedMenu(int playerChoice) {
        switch (playerChoice) {
            case 1:     //ma rozejrzeć się po pokoju, opis + lista przedmiotow
                System.out.println(eventDirector.itemList());
                break;
            case 2:     //ma pobrać info na czym ma się skupić

                break;
            case 0:     //ma wyjść z gry

                break;
            default:


        }
    }
    private void itemDetailedMenu(int playerChoice) {
            switch (playerChoice) {
                case 1:     //oglądanie przedmiotu - może ustawić flagę na true
                    break;
                case 2:     //manipulacja przedmiotem - sprawdza flagę przyglądania lub łączenie
                    break;
                case 3:     //łączenie przedmiotu z innym w pokoju - może sprawdzać flagi manipulacji i przyglądania
                    break;
                default:

            }
        }
    private String roomDialogFocus() {
        String roomMenuOut = """
                1 - Look around the room
                2 - Focus on specific object
                0 - Quit game
                """;
        return roomMenuOut;
    }

    private String itemDialogFocus() {
        String item = eventDirector.playerFocus().getItemName();
        String itemMenuOut = "1 - Get closer look at the " + item +
                            "\n2 - Manipulate the " + item +
                            "\n3 - Connect " + item + " with something else in the room";


        return itemMenuOut;
    }

    private int userInput() {
        Scanner scn = new Scanner(System.in);
        return Integer.parseInt(scn.nextLine());
    }


}
