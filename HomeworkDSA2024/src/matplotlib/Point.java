package matplotlib;

public class Point {
    private int x;
    private int y;
    public final static int deltaX = 100;
    public final static int deltaY = 550;

    public Point() {
        this.x = deltaX;
        this.y = deltaY;
    }

    public Point(int x, int y) {
        this.x = x + deltaX;
        this.y = deltaY - y;
    }

    public Point(Point p) {
        this.x = p.x;
        this.y = p.y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x + deltaX;
    }

    public void setY(int y) {
        this.y = deltaY - y;
    }
    

    public void setPoint(int x, int y) {
        this.x = x + deltaX;
        this.y = deltaY - y;
    }

    public void setPoint(Point p) {
        this.x = p.x;
        this.y = p.y;
    }

    @Override
    public String toString() {
        return x + " " + y;
    }
}
