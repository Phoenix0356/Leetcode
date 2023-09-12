package medium;

import java.util.ArrayList;
import java.util.List;

public class canFinish {
    List<List<Integer>> edges;
    int[] state;
    boolean isValid=true;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        edges=new ArrayList<>();
        state=new int[numCourses];
        for (int i=0;i<numCourses;i++) edges.add(new ArrayList<Integer>());
        for (int[] info:prerequisites){
            edges.get(info[0]).add(info[1]);
        }
        for (int i=0;i<state.length;i++){
            if (state[i]==0) dfs(i);
        }
        return isValid;
    }
    void dfs(int i){
        state[i]=1;
        for (int n:edges.get(i)){
            if (state[n]==0) {
                dfs(n);
                if (!isValid) return;
            }
            else if (state[n]==1) {
                isValid=false;
                return;
            }
        }
        state[i]=2;
    }
}
