package medium;

import java.util.*;

public class orangesRotting {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new ArrayDeque<>();
        HashSet<Integer> emptySet = new HashSet<>();
        int cnt = 0;
        boolean[][] visitedSet = new boolean[grid.length][grid[0].length];
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j] == 2){
                    q.offer(new int[]{i,j});
                }
            }
        }
        while(!q.isEmpty()&&!isStained(grid)){
            cnt++;
            int curLen = q.size();
            ArrayList<int[]> bufferList = new ArrayList<>();
            for(int i = 0;i<curLen;i++){
                int[] cur = q.poll();
                int row = cur[0];
                int col = cur[1];
                bufferList.add(spread(q,grid,visitedSet,new int[]{row-1,col}));
                bufferList.add( spread(q,grid,visitedSet,new int[]{row,col+1}));
                bufferList.add(spread(q,grid,visitedSet,new int[]{row+1,col}));

                bufferList.add(spread(q,grid,visitedSet,new int[]{row,col-1}));
            }
            for (int[] nums : bufferList) {
                if (nums != null) {
                    q.offer(nums);
                }
            }
        }
        return isStained(grid)?cnt:-1;
    }

    boolean isStained(int[][] grid){
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    return false;
                }
            }
        }
        return true;
    }

    int[] spread(Queue<int[]> q, int[][] grid, boolean[][] isVisited, int[] target){
        if(target[0]>=0&&target[0]<grid.length&&
                target[1]>=0&&target[1]<grid[0].length
                &&!isVisited[target[0]][target[1]]&&
                grid[target[0]][target[1]]!=0){
            grid[target[0]][target[1]] = 2;
            isVisited[target[0]][target[1]] = true;
            return target;
        }
        return null;
    }
}
