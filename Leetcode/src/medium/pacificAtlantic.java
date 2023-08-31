package medium;


import java.util.ArrayList;
import java.util.List;

public class pacificAtlantic {
    int i=0,j=0;
    boolean isP=false,isA=false;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
       List<List<Integer>> l=new ArrayList<>();
        for (i=0;i<heights.length;i++){
            for (j=0;j<heights[0].length;j++){
                isP=false;isA=false;
                if (dfs(heights,i,j)){
                    List<Integer> ls= new ArrayList<>();
                    ls.add(i);ls.add(j);
                    l.add(ls);
                }
            }
        }
        return l;
    }
    private boolean dfs(int[][] h,int x,int y){
        int count=0;
        int[][] height=new int[h.length][h[0].length];
        for (int i=0;i<h.length;i++){
            for (int j=0;j<h[0].length;j++){
                height[i][j]=h[i][j];
                }
            }
        for (int[] a : dir) {
            if (count==4){
                return false;
            }
            if (x+a[0]<0||y+a[1]<0){
                isP=true;
                dfs(height,i,j);
            }else if (x+a[0]==height[0].length||y+a[1]>height.length){
                isA=true;
                dfs(height,i,j);
            }
            if (isA&&isP){
                return true;
            }
            if (height[x + a[0]][y + a[1]] <= height[x][y]) {
                height[x][y]=Integer.MAX_VALUE;
                if (!dfs(height,x + a[0],y + a[1])){
                    return false;
                }else {
                    return true;
                }
            }else {
                count++;
            }
        }
        return false;
    }
    int[][] dir={{-1,0},{0,-1},{1,0},{0,1}};
}
