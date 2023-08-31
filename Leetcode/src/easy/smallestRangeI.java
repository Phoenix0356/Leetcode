package easy;

import java.lang.reflect.Array;
import java.util.Arrays;

public class smallestRangeI {
    public int smallestRangeI(int[] nums, int k) {
        Arrays.sort(nums);
        int ans=nums[nums.length-1]-nums[0]-2*k;
        if (ans<0)return 0;
        return ans;
    }
}
