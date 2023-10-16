package medium;

import java.util.HashMap;

public class singleNumber3 {
    public int[] singleNumber(int[] nums) {
        int[] ans=new int[2];
        int idx=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int n:nums){
            map.put(n,map.getOrDefault(n,0)+1);
        }
        for (int k:map.keySet()){
            if (map.get(k)==1){
                ans[idx++]=k;
            }
        }
        return ans;
    }
}
