package ZadDom.PostOffice;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class POPackage {

    private String sender;
    private String recipient;
    private int weightInGrams;
    private boolean priority;
    private DeliveryStatus packageStatus = DeliveryStatus.CREATED;

    public POPackage() {
        Random rnd = new Random();
        ArrayList<String> names = new ArrayList<>(Arrays.asList("Milena", "Tomasz", "Marcin", "Bartosz", "Agnieszka", "Joanna", "Patrycja"));

        sender = names.get(rnd.nextInt(names.size()));
        names.remove(sender);
        recipient = names.get(rnd.nextInt(names.size()));

        weightInGrams = rnd.nextInt(100_001) + 1;

        if (rnd.nextInt(10) >= 7) {
            priority = true;
        }


    }

    public POPackage(String sender, String recipient, int weightInGrams) {
        if (sender == null || sender.isEmpty() || recipient == null || recipient.isEmpty()) {
            setPackageStatus(DeliveryStatus.DELETED);
            System.out.println("Sender or Recipient field cannot be empty");
            return;
        } else if (weightInGrams < 1 || weightInGrams > 100_000) {
            System.out.println("Invalid weight");
            return;
        }

        this.sender = sender;
        this.recipient = recipient;
        this.weightInGrams = weightInGrams;

    }

    public POPackage(String sender, String recipient, int weightInGrams, boolean priority) {
        this(sender, recipient, weightInGrams);
        this.priority = priority;
    }

    public double calculateTotalMailingCost() {
        double mailingCost = calculateMailingCost();
        if (priority) {
            return mailingCost + mailingCost * 0.1;
        }
        return mailingCost;
    }

    private double calculateMailingCost() {
        if (weightInGrams <= 500) {
            return 5.0;
        } else if (weightInGrams <= 1000) {
            return 8.0;
        } else if (weightInGrams <= 2000) {
            return 12.0;
        } else {
            return 12 + ((weightInGrams / 1000) - 2);
        }
    }

    public DeliveryStatus getPackageStatus() {
        return packageStatus;
    }

    public void setPackageStatus(DeliveryStatus packageStatus) {
        this.packageStatus = packageStatus;
    }

    @Override
    public String toString() {
        String stringOutput;
        if (weightInGrams >= 1000) {
            String weightInKilos = String.format("%.1f", weightInGrams * 0.001);
            stringOutput = "Sender: " + sender +
                    " | Recipient: " + recipient +
                    " | Weight: " + weightInKilos + "kg" +
                    " | Mailing cost: " + calculateTotalMailingCost() + " PLN";
        } else {
            stringOutput = "Sender: " + sender +
                    " | Recipient: " + recipient +
                    " | Weight: " + weightInGrams + " grams" +
                    " | Mailing cost: " + calculateTotalMailingCost() + " PLN";
        }

        return priority ? "Priority package status: " + getPackageStatus() + " | " + stringOutput : "Package status: " + getPackageStatus() + " | " + stringOutput;
    }
}
