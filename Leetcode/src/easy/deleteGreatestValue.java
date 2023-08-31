package easy;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class deleteGreatestValue {
    public int deleteGreatestValue(int[][] grid) {
        int ans = 0;
        for (int[] ints : grid) {
            Arrays.sort(ints);
            for (int j=0;j<grid[0].length;j++){
                if (ints[j]>grid[0][j]){
                    grid[0][j]=ints[j];
                }
            }

        }
        for (int k = 0; k<grid[0].length; k++) {
            ans += grid[0][k];
        }
        return ans;
    }
}
