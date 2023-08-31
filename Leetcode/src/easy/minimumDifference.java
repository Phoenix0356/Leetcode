package easy;

import java.util.Arrays;

public class minimumDifference {
    public int minimumDifference(int[] nums, int k) {
        if (nums.length==1)return 0;
        Arrays.sort(nums);
        int res=nums[k-1]-nums[0];
        for (int i=0;i+k-1<nums.length;i++){
            if (res > nums[i + k - 1] - nums[i]) {
                res=nums[i + k - 1] - nums[i];
            }
        }
        return  res;
    }
}
