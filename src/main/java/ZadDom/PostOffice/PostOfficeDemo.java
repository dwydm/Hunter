package ZadDom.PostOffice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PostOfficeDemo {

    private static List<POPackage> packages = new ArrayList<>();
    private static List<POLetter> letters = new ArrayList<>();

    public static void main(String[] args) {
        runPostOffice();

/*      POPackage pack1 = new POPackage("R", "S", 501);         //Poczta Part 1
        POPackage pack2 = new POPackage();
        POPackage pack3 = null;
        //POPackage pack4 = new POPackage(null,null,200);

        System.out.println(pack1.calculateTotalMailingCost());
        System.out.println(pack2.calculateTotalMailingCost());
        pack3 = pack1;
        //System.out.println(pack4.calculateTotalMailingCost());
        System.out.println(pack3.calculateTotalMailingCost());
*/
        //Poczta Part 2
        //POPackage[] packages = new POPackage[] {new POPackage(), new POPackage(), new POPackage("A", "B", 700)};
        //System.out.println(packages[0]);

/*        POPackage[] packagesHeap = new POPackage[100];
        fillArrayWithPackages(packagesHeap);
        displayAllPackagesAndTotalMailingCost(packagesHeap);*/


/*                                                              //Rozbudowa programu + Part 2
        PostOffice po = new PostOffice();       //test wysyłania paczki
        System.out.println(packages[2]);
        System.out.println("change: " + po.sendAPackage(100,packages[2]));
        System.out.println(packages[2]);
        System.out.println("change: " + po.sendAPackage(100, packages[0]));
        System.out.println(po.checkLastPackage());*/

    }

    public static void runPostOffice() {
        Scanner scn = new Scanner(System.in);
        boolean loopMenu = true;
        do {
            System.out.println("Choose an action");
            System.out.println("\t1. Create a package");
            System.out.println("\t2. Create a letter");
            System.out.println("\t3. Postal services");

            switch (scn.nextLine()) {
                case "1":
                    createPOPackageByUser();
                    break;
                case "2":
                    createPOLetterByUser();
                    break;
                case "3":
                    System.out.println();
                    postalServices();           //dodaje drugi poziom pętli z opcjami dostępnymi dla poczty
                    break;
                default:
                    loopMenu = false;
            }
        } while (loopMenu);
    }

    private static void postalServices() {
        Scanner scn = new Scanner(System.in);
        PostOffice postOffice = new PostOffice();
        boolean loopMenu = true;
        do {
            System.out.println("Choose postal service");
            System.out.println("\t1. Send a package");
            System.out.println("\t2. Send a letter");
            System.out.println("\t3. Display last package");
            System.out.println("\t4. Display created packages");
            System.out.println("\t5. Display created letters");
            System.out.println("\t6. Send a postman with letters");
            System.out.println("\t7. Show current post office revenue");

            double change;
            double money;

            switch (scn.nextLine()) {
                case "1":
                    System.out.println("Enter package number");
                    int packageNum = Integer.parseInt(scn.nextLine());
                    if (packageNum > packages.size() || packageNum < 1) {
                        System.out.println("Unable to find package with that number");
                        break;
                    }
                    System.out.println("Enter the amount of money for postal service");
                    change = postOffice.sendAPackage(Double.parseDouble(scn.nextLine()), packages.get(packageNum - 1));
                    System.out.printf("Your change: %.2fPLN\n", change);
                    if (packages.get(packageNum - 1).getPackageStatus() == DeliveryStatus.SUBMITTED) {
                        packages.remove(packageNum - 1);
                    }
                    break;
                case "2":
                    System.out.println("Enter letter number");
                    int letterNum = Integer.parseInt(scn.nextLine());
                    if (letterNum > letters.size() || letterNum < 1) {
                        System.out.println("Unable to find letter with provided number");
                        break;
                    }
                    System.out.println("Enter the amount of money for postal service");
                    money = Double.parseDouble(scn.nextLine());
                    change = postOffice.sendLetter(money, letters.get(letterNum - 1));
                    System.out.printf("Your change: %.2fPLN\n", change);
                    if (money != change) {
                        letters.remove(letterNum - 1);
                    }
                    break;
                case "3":
                    if (postOffice.checkLastPackage() != null) {
                        System.out.println(postOffice.checkLastPackage());
                    }
                    break;
                case "4":
                    POPackage[] packagesArray = new POPackage[packages.size()];
                    packagesArray = packages.toArray(packagesArray);
                    displayAllPackagesAndTotalMailingCost(packagesArray);
                    break;
                case "5":
                    displayAllLettersAndTotalMailingCost(letters);
                    break;
                case "6":
                    postOffice.sendPostman();
                    break;
                case "7":
                    System.out.printf("Post office revenue: %.2fPLN\n" + postOffice.getRevenue());
                    break;
                default:
                    loopMenu = false;
            }
        } while (loopMenu);
    }

    private static void createPOPackageByUser() {
        Scanner scn = new Scanner(System.in);
        POPackage poPackage;
        System.out.println("Provide sender name");
        String sender = scn.nextLine();
        System.out.println("Provide recipient name");
        String recipient = scn.nextLine();
        System.out.println("Provide package's weight (in grams)");
        int weight = Integer.parseInt(scn.nextLine());
        System.out.println("Would you like it to be priority service?  y/n");
        String userPriorityInput = scn.nextLine();
        if (userPriorityInput.equalsIgnoreCase("y") || userPriorityInput.equalsIgnoreCase("yes")) {
            poPackage = new POPackage(sender, recipient, weight, true);
        } else {
            poPackage = new POPackage(sender, recipient, weight);
        }

        if (!poPackage.getPackageStatus().equals(DeliveryStatus.DELETED)) {      //zapobiega dodaniu obiektu null do listy paczek
            System.out.println("Package was successfully created");
            packages.add(poPackage);
        }
    }

    private static void createPOLetterByUser() {
        Scanner scn = new Scanner(System.in);
        String[] addressFields = new String[]{"sender", "recipient"};
        Address[] addressesArray = new Address[2];
        String street;
        String houseNum;
        String postalCode;

        for (int i = 0; i < addressFields.length; i++) {            //pętla w celu pominięcia powtarzających się pytań, wykorzystuje tablice do wymiany infomacji z userem
            System.out.println("Enter " + addressFields[i] + " street name");
            street = scn.nextLine();
            System.out.println("Enter " + addressFields[i] + " house number");
            houseNum = scn.nextLine();
            System.out.println("Enter " + addressFields[i] + " postal code");
            postalCode = scn.nextLine();

            addressesArray[i] = new Address(street, houseNum, postalCode);
        }
        System.out.println("Should it be priority service? y/n");   //wybiera konstruktor zależy od priorytetu, a następnie dodaje obiekt do listy
        if (scn.nextLine().equalsIgnoreCase("y")) {
            letters.add(new POLetter(addressesArray[0], addressesArray[1], true));
        } else {
            letters.add((new POLetter(addressesArray[0], addressesArray[1])));
        }
    }

    private static void displayAllPackagesAndTotalMailingCost(POPackage... poPackages) {    //wyświetla wszystkie paczki z listy do zadania części 2
        double totalCost = 0.0;                                                             //metoda wykorzystywana do wyświetlania zawartości listy - numerowana od 1
        int counter = 1;
        for (POPackage poPackage : poPackages) {
            System.out.println(counter + ". " + poPackage);
            totalCost += poPackage.calculateTotalMailingCost();
            counter++;
        }
        System.out.printf("Total cost of all " + poPackages.length + " packages: %.2f PLN\n", totalCost);
    }

    private static void displayAllLettersAndTotalMailingCost(List<POLetter> letters) {
        double totalCost = 0.0;
        int counter = 1;
        for (POLetter poLetter : letters) {
            System.out.println(counter + ". " + poLetter);
            totalCost += poLetter.calculateLetterCost();
            counter++;
        }
        System.out.printf("Total cost of all " + letters.size() + " letters: %.2f PLN\n", totalCost);
    }

    public static void fillArrayWithPackages(POPackage... poPackages) {
        for (int i = 0; i < poPackages.length; i++) {
            poPackages[i] = new POPackage();
        }
    }

}
