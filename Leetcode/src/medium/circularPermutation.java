package medium;

import java.util.ArrayList;
import java.util.List;

public class circularPermutation {
    double[] operation=new double[]{2,0.5,-1};
    ArrayList<Integer> nums;
    int len;
    public List<Integer> circularPermutation(int n, int start) {
        len=1<<n;
        nums= new ArrayList<>();
        nums.add(start);
        dfs(1);
        return nums;
    }
    boolean dfs(int ind){
        int prev=nums.get(ind-1);
        int cnt=0;
        while (prev>0){
            if (prev%2!=1) {
                prev /= 2;
                cnt++;
                continue;
            }
            for (double d:operation){
                int cur=nums.get(ind-1)+(int)d*(1<<cnt);
                System.out.println(cnt);
                if (cur>=len) continue;

                nums.add(cur);
                if (ind++==len-1) return nums.get(0) == cur;
                if (!dfs(ind)) nums.remove(ind);
            }
            prev/=2;
        }
        return false;
    }

}
