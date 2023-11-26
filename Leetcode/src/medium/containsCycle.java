package medium;

import java.util.HashSet;

public class containsCycle {
    int[][] directions=new int[][]{{0,-1},{0,1},{-1,0},{1,0}};//左右上下
    boolean[][] flag;
    int rowL,colL;
    public boolean containsCycle(char[][] grid) {
        rowL= grid.length;
        colL=grid[0].length;
        flag=new boolean[rowL][colL];
        for (int i=0;i< grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                if (flag[i][j]) continue;
                if (dfs(grid,i,j,0,0))return true;
            }
        }
        return false;
    }
    boolean dfs(char[][] grid,int row,int col,int preRow,int preCol){
        if (flag[row][col]) return true;
        flag[row][col]=true;
        char cur=grid[row][col];
        for (int[] dir:directions){
            if (preRow==-dir[0]&&preCol==-dir[1]) continue;
            int newRow=row+dir[0];
            int newCol=col+dir[1];
            if (newRow>=0&&newRow<rowL
                    &&newCol>=0&&newCol<colL
                    &&grid[newRow][newCol]==cur){
                if (dfs(grid,newRow,newCol,dir[0],dir[1])){
                    return true;
                }
            }
        }
        return false;
    }
}
