package medium;

import java.util.ArrayList;
import java.util.List;

public class spiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        int[][] directions=new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        List<Integer> l=new ArrayList<>();
        int newRow=0,newCol=0;
        int curDir=0,curTurn=0;
        while (l.size()< matrix.length* matrix[0].length){

            if (newRow+curTurn+directions[curDir][0]==matrix.length||
                    newCol+curTurn+directions[curDir][1]==matrix[0].length||
                    newRow-curTurn+directions[curDir][0]==-1||
                    newCol-curTurn+directions[curDir][1]==-1
            ){
                if (++curDir==4) {
                    curDir=0;
                    curTurn++;
                }

            }
            newRow+=directions[curDir][0];
            newCol+=directions[curDir][1];
            l.add(matrix[newRow][newCol]);
        }
        return l;
    }

}
