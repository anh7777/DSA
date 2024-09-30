package matplotlib;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        JaPlot plt = new JaPlot();
        List<Point> points = new ArrayList<>();
        List<Integer> xticks = new ArrayList<>();
        List<Integer> yticks = new ArrayList<>();
        for (int i = 0; i < 1000; i += 10) {
            points.add(new Point(i , (int) Math.pow(i, 2)));
        }
        for (int i = 0; i <= 1000; i += 100) {
            xticks.add((Integer) i);
            yticks.add((Integer) i);
        }
        // points.add(new Point(14, 5));
        plt.plot(points, "p", Color.BLUE, "y = x^2");
        plt.plot(points, "l", Color.RED, "y = x^2");
        plt.xtick(xticks);
        plt.ytick(yticks);
        plt.show();
    }
}
