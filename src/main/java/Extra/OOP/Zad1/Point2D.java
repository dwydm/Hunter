package Extra.OOP.Zad1;

public class Point2D {
    private float x;
    private float y;

    public Point2D() {
        x = 0.0f;
        y = 0.0f;
    }

    public Point2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float[] getXY() {
        return new float[] {x,y};
    }

    @Override
    public String toString() {
        return "x: " + x + " y: " + y;
    }
}
