package medium;

import java.util.Arrays;
import java.util.Formattable;

public class generateMatrix {
    public static int[][] directions=new int[][]{{0,1},{1,0},{0,-1},{-1,0}};//右下左上
    int[][] matrix;
    public int[][] generateMatrix(int n) {

        if (n==1) return new int[][]{{1}};
        matrix=new int[n][n];
        matrix[0][0]=1;
        fill(0,0,0,2);
        return matrix;

    }
    void fill(int row,int column,int state,int count){
        boolean isChange=false;

        int newRow=row+directions[state][0];
        int newCol=column+directions[state][1];

        if (newRow==matrix[0].length||newRow==-1||newCol==matrix.length||newCol==-1){
            isChange=true;
        }
        else if (matrix[newRow][newCol]!=0){
            isChange=true;
        }
        if (isChange){
            if (++state==directions.length) state=0;
        }

        newRow=row+directions[state][0];
        newCol=column+directions[state][1];
        if (matrix[newRow][newCol]!=0){
            return;
        }

        matrix[newRow][newCol]=count++;
        fill(newRow,newCol,state,count);
    }
}
