import java.awt.*;
import java.util.*;
import java.util.List;

import matplotlib.JaPlot;
import matplotlib.Point;

public class Main {
    public static void main(String[] args) {
        JaPlot plt = new JaPlot();
        List<Point> points = new ArrayList<>();
        List<Integer> xticks = new ArrayList<>();
        List<Integer> yticks = new ArrayList<>();
        for (int i = 0; i < 1000; i += 10) {
            points.add(new Point(i , i));
        }
        for (int i = 0; i <= 1000; i += 100) {
            xticks.add((Integer) i);
            yticks.add((Integer) i);
        }
        // points.add(new Point(14, 5));
        plt.plot(points, "p", Color.BLUE, "y = x");
        plt.plot(points, "l", Color.RED, "y = x");
        plt.xtick(xticks);
        plt.ytick(yticks);
        plt.show();
    }
}