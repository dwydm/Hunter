package Cwiczenia.Workshop;

import java.util.List;

public class Receipt {

    private List<WorkshopServices> servicesList;
    private double costTotal = 0;

    public Receipt(List<WorkshopServices> servicesList) {
        this.servicesList = servicesList;
        totalRepairCost();
    }

    public void addServiceToReceipt(WorkshopServices serviceName) {
        servicesList.add(serviceName);
        costTotal += serviceName.repairCost;
    }

    private void totalRepairCost() {
        for (WorkshopServices service : servicesList) {
            costTotal += service.repairCost;
        }
    }

    @Override
    public String toString() {
        String strOutput = "\tReceipt:\n";

        for (WorkshopServices service : servicesList) {
            strOutput += service.description + (".").repeat(10) + " " + service.repairCost + "\n";
        }
        strOutput += "Number of repairs: " + servicesList.size();
        strOutput += "\nTotal cost: " + costTotal;

        return strOutput;
    }
}
