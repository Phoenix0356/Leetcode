package medium;

public class getMaximumGold {
    int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0,-1}};
    public int getMaximumGold(int[][] grid) {
        int res=0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                res=Math.max(res,dfs(grid,row,col));
            }

        }
        return res;
    }
    private int dfs(int[][] grid,int row,int col){
        if(grid[row][col]==0)return 0;
        int goldNum=0;int  nextMax=0;
        goldNum=grid[row][col];
        grid[row][col]=0;
        for(int[] step:dir){
            int nextRow=row+step[0];int nextCol=col+step[1];
            if(nextRow>=0&&nextRow<grid.length&&nextCol>=0&&nextCol<grid[0].length){
                nextMax=Math.max(nextMax,dfs(grid,nextRow,nextCol));
            }
        }
        grid[row][col]=goldNum;
        return nextMax+goldNum;
    }
}
