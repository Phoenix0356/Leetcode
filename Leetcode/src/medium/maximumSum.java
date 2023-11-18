package medium;

import java.util.HashMap;
import java.util.HashSet;

public class maximumSum {
    public int maximumSum(int[] nums) {
        int max=-1;
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i=0;i< nums.length;i++){
            int cur=nums[i],weightsSum=0;
            while (cur>0){
                weightsSum+=cur%10;
                cur/=10;
            }
            if (map.containsKey(weightsSum)){
                max=Math.max(map.get(weightsSum)+nums[i],max);
                if (map.get(weightsSum)<nums[i])map.put(weightsSum,nums[i]);
            }
            else map.put(weightsSum, nums[i]);
        }
        return max;
    }
}
