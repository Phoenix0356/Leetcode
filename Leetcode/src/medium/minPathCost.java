package medium;

import java.util.Arrays;

public class minPathCost {
    public int minPathCost(int[][] grid, int[][] moveCost) {
        int[][] dp=new int[grid.length][grid[0].length];
        System.arraycopy(grid[0], 0, dp[0], 0, grid[0].length);
        for (int i=1;i< grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                int min=moveCost[grid[i-1][0]][j]+dp[i-1][0];
                for (int k=1;k<grid[0].length;k++){
                    min=Math.min(min,moveCost[grid[i-1][k]][j]+dp[i-1][k]);
                }
                dp[i][j]=min+grid[i][j];
            }
        }

        return Arrays.stream(dp[dp.length-1]).min().getAsInt();
    }
}
