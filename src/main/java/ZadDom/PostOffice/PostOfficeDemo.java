package ZadDom.PostOffice;

public class PostOfficeDemo {
    public static void main(String[] args) {
        POPackage pack1 = new POPackage("R", "S", 501);
        POPackage pack2 = new POPackage();
        POPackage pack3 = null;
        //POPackage pack4 = new POPackage(null,null,200);

        System.out.println(pack1.calculateTotalMailingCost());
        System.out.println(pack2.calculateTotalMailingCost());
        pack3 = pack1;
        //System.out.println(pack4.calculateTotalMailingCost());
        System.out.println(pack3.calculateTotalMailingCost());




    }
}
