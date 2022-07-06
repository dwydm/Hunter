package Extra.OOP.Zad5;

import Extra.OOP.Zad1.Point2D;

public class Line {

    private Point2D egdeA;
    private Point2D egdeB;

    public  Line(Point2D egdeA, Point2D egdeB) {
        this.egdeA = egdeA;
        this.egdeB = egdeB;
    }

    public Line(float xA, float yA, float xB, float yB) {
        egdeA = new Point2D(xA,yA);
        egdeB = new Point2D(xB, yB);
    }

    public Point2D getEgdeA() {
        return egdeA;
    }

    public void setEgdeA(Point2D egdeA) {
        this.egdeA = egdeA;
    }

    public Point2D getEgdeB() {
        return egdeB;
    }

    public void setEgdeB(Point2D egdeB) {
        this.egdeB = egdeB;
    }

    public float getLineLength(){
        float[] egdeA = getEgdeA().getXY();
        float[] egdeB = getEgdeB().getXY();

        double sideX = Math.pow(egdeA[0] - egdeB[0],2);
        double sideY = Math.pow(egdeA[1] - egdeB[1],2);

        return (float) Math.sqrt(sideX + sideY);
    }

    public Point2D getMiddleLinePoint() {
        float middlePointX;
        float middlePointY;

        middlePointX = (egdeA.getX() + egdeB.getX())/2;
        middlePointY = (egdeA.getY() + egdeB.getY())/2;
        return new Point2D(middlePointX,middlePointY);
    }

}
