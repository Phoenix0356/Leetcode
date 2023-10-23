package medium;

import java.util.Arrays;

public class minFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {
        for (int i=1;i< matrix.length;i++){
            for (int j=0;j<matrix[0].length;j++){
                if (j==0) {
                    matrix[i][j]+=Math.min(matrix[i-1][j],matrix[i-1][j+1]);
                    continue;
                }
                if (j==matrix[0].length-1) {
                    matrix[i][j]+=Math.min(matrix[i-1][j-1],matrix[i-1][j]);
                    continue;
                }
                matrix[i][j]+=Math.min(Math.min(matrix[i-1][j-1],matrix[i-1][j]),matrix[i-1][j+1]);
            }
        }
        Arrays.sort(matrix[matrix.length-1]);
        return matrix[matrix.length-1][0];
    }
}
