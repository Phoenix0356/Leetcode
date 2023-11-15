package medium;

import java.util.LinkedList;
import java.util.Queue;

public class findMaxFish {
    int[][] directions=new int[][]{{-1,0},{1,0},{0,-1},{0,1}};//上下左右
    boolean[][] flag;
    public int findMaxFish(int[][] grid) {
        flag=new boolean[grid.length][grid[0].length];
        int max=0;
        for (int i=0;i< grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                if (flag[i][j]||grid[i][j]==0)continue;
                //max=Math.max(max,bfs(grid,i,j));
                max=Math.max(max,dfs(grid,i,j));
            }
        }
        return max;
    }
    int bfs(int[][] grid,int row,int col){
        Queue<int[]> q=new LinkedList<>();
        int cnt=0;
        q.offer(new int[]{row,col});
        while (!q.isEmpty()) {
            int[] cur=q.poll();
            if (flag[cur[0]][cur[1]])continue;
            cnt+=grid[cur[0]][cur[1]];
            flag[cur[0]][cur[1]]=true;
            for (int[] direction : directions) {
                int newRow = cur[0] + direction[0];
                int newCol = cur[1] + direction[1];
                if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length&&grid[newRow][newCol]>0) {
                    q.offer(new int[]{newRow, newCol});
                }
            }
        }
        return cnt;
    }
    int dfs(int[][] grid,int row,int col){
        flag[row][col]=true;
        int cnt=0;
        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            if (newRow >= 0 && newRow < grid.length
                    && newCol >= 0 && newCol < grid[0].length
                    &&grid[newRow][newCol]>0&&!flag[newRow][newCol]) {
                cnt+=dfs(grid,newRow,newCol);
            }
        }
        return cnt==0?grid[row][col]:cnt+grid[row][col];
    }
}
