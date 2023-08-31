package easy;

public class diagonalSum {
    public int diagonalSum(int[][] mat) {
        int sum=0;
        for (int i=0;i<mat.length;i++){
            int right=mat.length-1-i;
            if (i==right ) sum-=mat[i][i];
            sum+=mat[i][i]+mat[i][mat.length-1-i];
        }
        return sum;
    }
}
