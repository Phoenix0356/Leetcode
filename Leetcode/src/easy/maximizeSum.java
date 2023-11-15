package easy;

import java.util.Arrays;

public class maximizeSum {
    public int maximizeSum(int[] nums, int k) {
        return (2*Arrays.stream(nums).max().getAsInt()+(k-1))*k/2;
    }
}
