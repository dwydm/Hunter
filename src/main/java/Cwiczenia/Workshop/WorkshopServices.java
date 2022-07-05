package Cwiczenia.Workshop;

public enum WorkshopServices {
    FLAT_TIRE_FIX("Punctured tire repair", 55.00 );

    final String description;
    final double repairCost;

    WorkshopServices (String description, double repairCost) {
        this.description = description;
        this.repairCost = repairCost;
    }
}
