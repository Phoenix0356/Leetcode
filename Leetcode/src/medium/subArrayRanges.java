package medium;

import java.util.Arrays;

public class subArrayRanges {
    public long subArrayRanges(int[] nums) {
        int left=0,right=0;
        long res=0;
        for (int i=0;i<nums.length;i++) {
            left = Integer.MAX_VALUE;
            right = Integer.MIN_VALUE;
            for (int j = 0; j < nums.length; j++) {
                left = Math.min(left, nums[j]);
                right = Math.max(right, nums[j]);
                res += right - left;
            }
        }
            return res;
    }

}
