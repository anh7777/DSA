package matplotlib;

import java.awt.*;
import java.awt.geom.Line2D;
import java.util.List;

public class DrawLine extends DrawPoint {
    public DrawLine(List<Point> points, Color color, String name) {
        super(points, color, name);
    }

    @Override
    public void plot(Graphics2D g) {
        g.setColor(color);
        for (int i = 0; i < points.size() - 1; i++) {
            Point p1 = points.get(i);
            Point p2 = points.get(i + 1);
            Line2D.Double line = new Line2D.Double(p1.getX(), p1.getY(), p2.getX(), p2.getY());
            g.draw(line);
        }
        g.drawString(name, points.get(points.size() - 1).getX(), points.get(points.size() - 1).getY() - 6);
    }
}
