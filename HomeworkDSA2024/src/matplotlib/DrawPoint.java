package matplotlib;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.List;



public class DrawPoint {
    protected List<Point> points;
    protected Color color;
    protected String name;

    public DrawPoint (List<Point> points, Color color, String name) {
        this.points = points;
        this.color = color;
        this.name = name;
    }

    public void plot(Graphics2D g) {
        g.setColor(color);
        for (Point p : points) {
            Ellipse2D.Double point = new Ellipse2D.Double(p.getX() - 2, p.getY() - 2, 5, 5);
            g.fill(point);
        }
        Point p = points.get(points.size() - 1);
        g.drawString(name, p.getX(), p.getY() - 6);
        // System.out.println(name);
    }

    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }

    public String getName() {
        return name;
    }
}