package ZadDom.PostOffice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PostOfficeDemo {

    private static List<POPackage> packages = new ArrayList<>();
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

    public static void runPostOffice(){
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
                    break;
                case "3":
                    System.out.println();
                    postalServices();
                    break;
                default:
                    loopMenu = false;
            }
        }while(loopMenu);
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

            switch (scn.nextLine()) {
                case "1":
                    System.out.println("Enter package number");
                    int packageNum = Integer.parseInt(scn.nextLine());
                    if(packageNum > packages.size() || packageNum < 1) {
                        System.out.println("Unable to find package with that number");
                        break;
                    }
                    System.out.println("Enter the amount of money for postal service");
                    System.out.printf("Your change: %.2fPLN\n", postOffice.sendAPackage(Double.parseDouble(scn.nextLine()),packages.get(packageNum-1)));
                    if (packages.get(packageNum-1).getPackageStatus() == DeliveryStatus.SUBMITTED) {
                        packages.remove(packageNum-1);
                    }
                    break;
                case "2":
                    break;
                case "3":
                    if(postOffice.checkLastPackage() != null){
                        System.out.println(postOffice.checkLastPackage());
                    }
                    break;
                case "4":
                    POPackage[] packagesArray = new POPackage[packages.size()];
                    packagesArray = packages.toArray(packagesArray);
                    displayAllPackagesAndTotalMailingCost(packagesArray);
                    break;
                case "5":
                    break;
                default:
                    loopMenu = false;
            }
        }while (loopMenu);
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
        if(userPriorityInput.equalsIgnoreCase("y") || userPriorityInput.equalsIgnoreCase("yes")){
            poPackage = new POPackage(sender,recipient,weight,true);
        } else {
            poPackage = new POPackage(sender,recipient,weight);
        }

        if(!poPackage.getPackageStatus().equals(DeliveryStatus.DELETED)) {
            System.out.println("Package was successfully created");
            packages.add(poPackage);
        }
    }

    private static void displayAllPackagesAndTotalMailingCost(POPackage... poPackages) {
        double totalCost = 0.0;
        int counter = 1;
        for (POPackage poPackage : poPackages) {
            System.out.println(counter + ". " + poPackage);
            totalCost += poPackage.calculateTotalMailingCost();
            counter++;
        }
        System.out.printf("Total cost of all " + poPackages.length + " packages: %.2f PLN\n", totalCost);
    }

    public static void fillArrayWithPackages(POPackage... poPackages) {
        for (int i = 0; i < poPackages.length; i++) {
            poPackages[i] = new POPackage();
        }
    }

}
