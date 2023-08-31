package easy;

import java.util.Arrays;
import java.util.Comparator;

public class checkStraightLine {
    public boolean checkStraightLine(int[][] coordinates) {
        double x1=coordinates[0][0],x2=coordinates[1][0];
        double y1=coordinates[0][1],y2=coordinates[1][1];
        double k=(y2-y1)/(x2-x1);
        double b=y1-k*x1;

        for (int i=2;i<coordinates.length;i++) {
            if (coordinates[i][1]!=k*coordinates[i][0]+b) return false;
        }

        return true;
    }
}
