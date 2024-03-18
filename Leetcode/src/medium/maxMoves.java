package medium;

import java.util.Arrays;

public class maxMoves {
    public int maxMoves(int[][] grid) {
        int max = 0;
        int rowLen = grid.length;
        int colLen = grid[0].length;
        int[][][] arr = new int[rowLen+2][colLen+1][3];


        for (int i = 0;i< arr.length;i++){
            for (int j = 0;j<arr[0].length;j++){

                if (i==0||j==0||i==arr.length-1) arr[i][j][0] = Integer.MAX_VALUE;
                else arr[i][j][0] = grid[i-1][j-1];

                if (j == 1) arr[i][j][2] = 1;

                System.out.println(arr[i][j][0]);
            }
            System.out.println();
        }

        for (int i = 1;i<arr.length-1;i++) {
            for (int j = 1; j < arr[0].length; j++) {
                int preMax = 0;
                for (int k = -1; k < 2;k++){
                    if (arr[i+k][j-1][0]<arr[i][j][0]&&arr[i+k][j-1][2] == 1) {
                        arr[i][j][2] = 1;
                        preMax = Math.max(preMax,arr[i+k][j-1][1]);
                    }
                }
                if (arr[i][j][2] == 1) arr[i][j][1] = preMax + 1;

            }
        }

        for (int i = 1;i< arr.length-1;i++){
            max = Math.max(max,arr[i][arr[0].length-1][1]);
        }
        return max;
    }
}
