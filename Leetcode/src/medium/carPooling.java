package medium;

import java.util.Arrays;
import java.util.Comparator;

public class carPooling {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] diff = new int[1001];
        for (int[] trip : trips) {
            diff[trip[1]]+=trip[0];
            diff[trip[2]]+=trip[0];
        }
        if (diff[0]>capacity) return false;
        for (int i = 1;i<diff.length;i++){
            diff[i] = diff[i]+diff[i-1];
            if (diff[i]>capacity) return false;
        }
        return true;
    }
}
