package hard;

import java.util.Arrays;

public class minFallingPathSum2 {
    public int minFallingPathSum(int[][] grid) {
        for (int i=1;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                int min=Integer.MAX_VALUE;
                for (int k=0;k<grid[0].length;k++){
                    if (k==j) continue;
                    min=Math.min(min,grid[i-1][k]);
                }
                grid[i][j]+=min;
            }
        }
        return Arrays.stream(grid[grid.length-1]).min().getAsInt();
    }
}
