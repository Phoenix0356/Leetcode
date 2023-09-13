package medium;

public class checkValidGrid {
    int[][] directions=new int[][]{{-2,-1},{2,-1},{2,1},{-2,1},{1,2},{1,-2},{-1,2},{-1,-2}};

    public boolean checkValidGrid(int[][] grid) {
        if (grid[0][0]!=0) return false;


        return dfs(grid,0,0,1);
    }
    boolean dfs(int[][] grid,int row ,int col,int curStep){
        for (int[] direction:directions){
            int curRow=row+direction[0],curCol=col+direction[1];
            if (curRow >= 0 && curRow < grid.length && curCol >= 0 && curCol < grid[0].length){
                if (grid[curRow][curCol]==curStep){
                    if (++curStep==grid.length*grid[0].length-1) return true;
                    return dfs(grid,curRow,curCol,curStep);
                }
            }
        }
        return false;

    }
}
