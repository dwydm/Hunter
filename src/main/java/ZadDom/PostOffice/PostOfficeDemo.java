package ZadDom.PostOffice;

public class PostOfficeDemo {
    public static void main(String[] args) {
/*      POPackage pack1 = new POPackage("R", "S", 501);
        POPackage pack2 = new POPackage();
        POPackage pack3 = null;
        //POPackage pack4 = new POPackage(null,null,200);

        System.out.println(pack1.calculateTotalMailingCost());
        System.out.println(pack2.calculateTotalMailingCost());
        pack3 = pack1;
        //System.out.println(pack4.calculateTotalMailingCost());
        System.out.println(pack3.calculateTotalMailingCost());
*/
        POPackage[] packages = new POPackage[] {new POPackage(), new POPackage(), new POPackage("A", "B", 700)};
        System.out.println(packages[0]);

        POPackage[] packagesHeap = new POPackage[100];
        fillArrayWithPackages(packagesHeap);
        displayAllPackagesAndTotalMailingCost(packagesHeap);


    }

    private static void displayAllPackagesAndTotalMailingCost(POPackage... poPackages) {
        double totalCost = 0.0;
        for (POPackage poPackage : poPackages) {
            System.out.println(poPackage);
            totalCost += poPackage.calculateTotalMailingCost();
        }
        System.out.printf("Total cost of all " + poPackages.length + " packages: %.2f PLN", totalCost);
    }

    public static void fillArrayWithPackages(POPackage... poPackages) {
        for (int i = 0; i < poPackages.length; i++) {
            poPackages[i] = new POPackage();
        }
    }

}
