package medium;

import java.util.Random;

public class randPoint {
    double r, x, y;
    Random random = new Random();
    public randPoint(double _r, double _x, double _y) {
        r = _r; x = _x; y = _y;
    }
    public double[] solution() {
        double len = Math.sqrt(random.nextDouble(r * r)), ang = random.nextDouble(2 * Math.PI);
        double nx = x + len * Math.cos(ang), ny = y + len * Math.sin(ang);
        return new double[]{nx, ny};
    }
}
