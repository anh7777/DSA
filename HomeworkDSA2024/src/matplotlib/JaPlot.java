package matplotlib;

import java.awt.*;
import java.util.List;
import javax.swing.*;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

public class JaPlot {
    private JFrame frame;
    private List<DrawPoint> plots;
    private List<DrawPoint> Oxy;
    private int width, height;
    private int x, y;
    private Point px, py;
    public static final int dx = 700;
    public static final int dy = 500;
    private List<Point> xticks;
    private List<Point> yticks;

    public JaPlot() {
        width = 1000;
        height = 700;
        setting();
    }

    public JaPlot(int width, int height) {
        this.width = width;
        this.height = height;
        setting();
    }

    private void setting() {
        frame = new JFrame();
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        plots = new ArrayList<>();
        Oxy = new ArrayList<>();
        xticks = new ArrayList<>();
        yticks = new ArrayList<>();
        addOxy();
    }

    private void addOxy() {
        addOx();
        addOy();
        px = new Point(x, 0);
        py = new Point(0, y);
    }

    private void addOx() {
        List<Point> points = new ArrayList<>();
        // points.add(new Point((int) - Math.round(0.4*Point.deltaX), 0));
        points.add(new Point(0, 0));
        points.add(new Point(1000 - (int) Math.round(Point.deltaX * 2), 0));
        x = 1000 - (int) Math.round(Point.deltaX * 2);
        Oxy.add(new DrawLine(points, Color.BLACK, ""));
    }

    private void addOy() {
        List<Point> points = new ArrayList<>();
        points.add(new Point(0, 700 - (int) Math.round(0.3*Point.deltaY)));
        points.add(new Point(0, 0));
        // points.add(new Point(0, - (int) Math.round(0.1*Point.deltaY)));
        y = 700 - (int) Math.round(0.3*Point.deltaY);
        Oxy.add(new DrawLine(points, Color.BLACK, ""));
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void plot(List<Point> points, String style, Color color, String name) {
        if (style.equalsIgnoreCase("p") || style.equalsIgnoreCase("point")){
            plots.add(new DrawPoint(points, color, name));
        } else if (style.equalsIgnoreCase("line") || style.equalsIgnoreCase("l")) {
            plots.add(new DrawLine(points, color, name));
        }
    }

    public void plot(List<Point> points, String style, Color color) {
        if (style.equalsIgnoreCase("p") || style.equalsIgnoreCase("point")){
            plots.add(new DrawPoint(points, color, ""));
        } else if (style.equalsIgnoreCase("line") || style.equalsIgnoreCase("l")) {
            plots.add(new DrawLine(points, color, ""));
        }
    }

    public void plot(List<Point> points, String style) {
        if (style.equalsIgnoreCase("p") || style.equalsIgnoreCase("point")){
            plots.add(new DrawPoint(points, Color.BLACK, ""));
        } else if (style.equalsIgnoreCase("line") || style.equalsIgnoreCase("l")) {
            plots.add(new DrawLine(points, Color.BLACK, ""));
        }
    }

    public void plot(List<Point> points) {
        plots.add(new DrawPoint(points, Color.BLACK, ""));
    }

    public void plot(List<Point> points, Color color) {
        plots.add(new DrawPoint(points, color, ""));
    }

    public void plot(List<Integer> x, List<Integer> y, String style, Color color, String name) {
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < x.size(); i++) {
            points.add(new Point(x.get(i), y.get(i)));
        }
        plot(points, style, color, name);
    }

    public void plot(List<Integer> x, List<Integer> y, String style, Color color) {
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < x.size(); i++) {
            points.add(new Point(x.get(i), y.get(i)));
        }
        plot(points, style, color);
    }

    public void plot(List<Integer> x, List<Integer> y, String style) {
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < x.size(); i++) {
            points.add(new Point(x.get(i), y.get(i)));
        }
        plot(points, style);
    }

    public void plot(List<Integer> x, List<Integer> y) {
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < x.size(); i++) {
            points.add(new Point(x.get(i), y.get(i)));
        }
        plot(points);
    }

    public void xtick(List<Integer> xticks) {
        for (int i = 0; i < xticks.size(); i++) {
            this.xticks.add(new Point(xticks.get(i), 0));
        }

    }

    public void ytick(List<Integer> yticks) {
        for (int i = 0; i < yticks.size(); i++) {
            this.yticks.add(new Point(0, yticks.get(i)));
        }
    }

    private class Drawer extends JPanel{
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.BLACK);
            g.drawString("N", px.getX(), px.getY() - 12);
            g.drawString(">", px.getX(), px.getY() + 4);
            g.drawString("Time", py.getX() - 60, py.getY());
            g.drawString("^", py.getX() - 2, py.getY() + 4);
            Graphics2D g2 = (Graphics2D) g;
            for (DrawPoint plot : Oxy) {
                plot.plot(g2);
            }
            for (DrawPoint plot : plots) {
                plot.plot(g2);

            }
            
            if (xticks != null) {
                for (Point p : xticks) {
                    g.drawLine(p.getX(), p.getY(), p.getX(), p.getY() + 5);
                    g.drawString(p.getX() - Point.deltaX + "", p.getX() - 5, p.getY() + 20);
                }
            }

            if (yticks != null) {
                for (Point p : yticks) {
                    g.drawLine(p.getX(), p.getY(), p.getX() - 5, p.getY());
                    g.drawString(Point.deltaY - p.getY() + "", p.getX() - 30, p.getY() + 5);
                }
            }
        }
    }

    public int[] range() {
        int[] range = new int[2];
        range[0] = 1;
        range[1] = 1;
        for (DrawPoint plot : plots) {
            for (Point p : plot.getPoints()) {
                if (p.getX() - Point.deltaX> range[0]) {
                    range[0] = p.getX() - Point.deltaX;
                }
                if (Point.deltaY - p.getY() > range[1]) {
                    range[1] = Point.deltaY - p.getY();
                }
            }
        }
        return range;
    }

    private void solve() {
        int[] range = range();
        float deltaX = (float) dx / range[0];
        float deltaY = (float) dy / range[1];
        Map<List<Point>, Boolean> mp = new HashMap<>();
        for (DrawPoint plot : plots) {
            if (mp.get(plot.getPoints()) == null) {
                mp.put(plot.getPoints(), false);
            } else {
                continue;
            }
        }

        for (DrawPoint plot : plots) {
            if (mp.get(plot.getPoints())) {
                continue;
            }
            // System.out.println(plot.getPoints());
            for (Point p : plot.getPoints()) {
                p.setX((int) ((p.getX() - Point.deltaX) * deltaX));
                p.setY((int) ((Point.deltaY - p.getY()) * deltaY));   
            }
            mp.replace(plot.getPoints(), true);
        }
        // System.out.println(dx + " " + dy);
        // System.out.println(range[0] + " " + range[1]);
        // System.out.println(deltaX + " " + deltaY);
        for (Point p : xticks) {
            p.setX((int) ((p.getX() - Point.deltaX) * deltaX));
            p.setY((int) ((Point.deltaY - p.getY()) * deltaY));
        }

        for (Point p : yticks) {
            p.setX((int) ((p.getX() - Point.deltaX) * deltaX));
            p.setY((int) ((Point.deltaY - p.getY()) * deltaY));
        }
    }

    public void show() {
        solve();
        frame.add(new Drawer());
        frame.setVisible(true);
    }

    public void clear() {
        plots.clear();
        frame.getContentPane().removeAll();
    }
}
