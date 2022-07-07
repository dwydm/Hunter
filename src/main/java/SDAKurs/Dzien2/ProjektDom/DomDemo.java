package SDAKurs.Dzien2.ProjektDom;

public class DomDemo {
    public static void main(String[] args) {

        Dom dom = new Dom(new Pokoj(), new Pokoj(new Lozko(2),4));

        System.out.println(dom);

        //dom.getPokoj(0).posprzataj();
        //dom.getPokoj(1).posprzataj();
        dom.sprzatnijDom();
        System.out.println(dom);
        for(Okno okno : dom.getPokoj(1).getOkna()){
            System.out.println(okno);
            okno.zamknijOnko();
            System.out.println(okno);
        }




    }
}
