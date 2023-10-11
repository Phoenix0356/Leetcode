package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class pondSizes {
    public int[] pondSizes(int[][] land) {
        int[][] directions={{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
        boolean[][] isFind=new boolean[land.length][land[0].length];
        Queue<int[]> q=new LinkedList<>();
        ArrayList<Integer> l=new ArrayList<>();
        for (int i=0;i<land.length;i++){
            for (int j=0;j<land[0].length;j++){
                if (land[i][j]!=0||isFind[i][j]) continue;
                q.offer(new int[]{i,j});
                int size=1;
                while (!q.isEmpty()) {
                    int[] cur=q.poll();
                    for (int[] d:directions){
                        int x=cur[0]+d[0];
                        int y=cur[1]+d[1];
                        if (x<land.length-1&&x>=0&&y<land[0].length&&y>=0&&land[x][y]==0&&!isFind[x][y]){
                            size++;
                            isFind[x][y]=true;
                            q.offer(new int[]{x,y});
                        }
                    }
                }
                l.add(size);
            }
        }
        int[] arr=new int[l.size()];
        for (int i=0;i<l.size();i++) arr[i]=l.get(i);
        Arrays.sort(arr);
        return arr;
    }
}
