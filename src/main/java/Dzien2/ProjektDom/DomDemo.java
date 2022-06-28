package Dzien2.ProjektDom;

public class DomDemo {
    public static void main(String[] args) {

        Dom dom = new Dom(new Pokoj(), new Pokoj(new Lozko(5),4));

        System.out.println(dom);

        dom.getPokoj(0).posprzataj();
        dom.getPokoj(1).posprzataj();
        System.out.println(dom);




    }
}
