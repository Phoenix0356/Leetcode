package medium;

import java.util.Arrays;

public class findBall {
    public int[] findBall(int[][] grid) {
        int[] ans=new int[grid[0].length];
        int[] arr=new int[grid[0].length+2];
        for (int cnt=0;cnt<grid[0].length;cnt++){
            int col=cnt+1;
            for (int row=0;row<grid.length;row++) {
                System.arraycopy(grid[row],0,arr,1,grid[0].length);
                arr[0]=1;arr[grid[0].length+1]=-1;
                if (arr[col] == 1 && arr[col] == arr[col + 1]) {
                    col++;
                } else if (arr[col] == -1 && arr[col] == arr[col - 1]) {
                    col--;
                }else {
                    col=-1;
                    break;
                }
            }
            ans[cnt]=col==-1?-1:col;;
        }
        return ans;
    }
}
