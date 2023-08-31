package easy;

import java.util.Arrays;

public class maximumDifference {
    public int maximumDifference(int[] nums) {
       int ans=-1,premin=0;
        for (int i=0;i<nums.length;i++){
            if (nums[i]>premin){
                ans=Math.max(nums[i]-premin,ans);
            }else {
                premin=nums[i];
            }
        }
        return ans;
    }
}
