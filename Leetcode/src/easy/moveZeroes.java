package easy;

import java.util.Arrays;

public class moveZeroes {
    public void moveZeroes(int[] nums) {
        int[] arr = new int[nums.length];
        int ind = 0;
        for (int num : nums) if (num != 0) arr[ind++] = num;
        ind=0;
        for (int num : arr) nums[ind++]=num;

    }


}
