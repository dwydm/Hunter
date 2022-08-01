package Cwiczenia.Wzorce.Flyweight;

public class WarPieceDemo {
    public static void main(String[] args) {
        Destroyer destroyer = new Destroyer(20,-4);
        Tank tank = new Tank(12,34);
        Rifleman rifleman = new Rifleman(0,0);

        System.out.println(destroyer);
        System.out.println(rifleman);
        System.out.println(tank);
    }
}
