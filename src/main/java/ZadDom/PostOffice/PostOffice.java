package ZadDom.PostOffice;

import java.util.Stack;

public class PostOffice {
    private double revenue = 0.0;
    private Stack<POPackage> lastPackage = new Stack<>();
    private POLetter[] letterBox = new POLetter[10];
    boolean isLetterBoxFull;


    public double sendAPackage(double money, POPackage poPackage) {
        double mailingCost = poPackage.calculateTotalMailingCost();

        if(money < mailingCost) {
            System.out.println("Provided insufficient amount of money");
            return money;
        }
        revenue += mailingCost;
        poPackage.setPackageStatus(DeliveryStatus.SUBMITTED);
        lastPackage.push(poPackage);
        return money - mailingCost;
    }

    public double sendLetter(double money, POLetter poLetter) {
        if(isLetterBoxFull) {
            System.out.println("Sorry, this post office has reached it's maximum 10 letters / day limit");
            return money;
        }

        double mailingCost = poLetter.calculateLetterCost();
        if(mailingCost > money) {
            System.out.println("Provided insufficient amount of money");
            return money;
        }
        revenue += mailingCost;
        placeLetterInTheBox(poLetter);

        return money - mailingCost;
    }

    private void placeLetterInTheBox(POLetter poLetter) {
        for (int i = 0; i < letterBox.length; i++) {
            if(letterBox[i] == null && i == letterBox.length - 1) {
                letterBox[i] = poLetter;
                isLetterBoxFull = true;
            } else if (letterBox[i] == null) {
                letterBox[i] = poLetter;
            }

        }

    }

    public double getRevenue() {
        return revenue;
    }

    public POPackage checkLastPackage() {
        if(lastPackage.isEmpty()) {
            System.out.println("No packages in Post Office history");
            return null;
        }
        return lastPackage.peek();
    }
}
