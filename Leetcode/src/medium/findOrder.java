package medium;

import java.util.ArrayList;
import java.util.List;

public class findOrder {
    List<List<Integer>> edges;
    int[] state;
    int[] result;
    int ind;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        state=new int[numCourses];
        result=new int[numCourses];
        ind=0;
        edges=new ArrayList<>();
        for (int i=0;i<numCourses;i++) edges.add(new ArrayList<Integer>());
        for (int[] info:prerequisites) edges.get(info[0]).add(info[1]);
        for (int i=0;i<numCourses;i++){
            if (state[i]==0) {
                if (!dfs(i)) return new int[0];
            }
        }
        return result;
    }
    boolean dfs(int i){
        state[i]=1;
        for (int edge:edges.get(i)){
            if (state[edge]==0){
                if (!dfs(edge)) return false;
            }else if (state[edge]==1) return false;
        }
        state[i]=2;
        result[ind++]=i;
        return true;
    }
}
