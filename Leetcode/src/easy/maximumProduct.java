package easy;

import java.util.Arrays;

public class maximumProduct {
    public int maximumProduct(int[] nums) {
        int product = 0;
        Arrays.sort(nums);
        product = nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3];
        product = Math.max(product, nums[nums.length - 1] * nums[nums.length - 2] * nums[0]);
        product = Math.max(product, nums[nums.length - 1] * nums[1] * nums[0]);
        product = Math.max(product, nums[0] * nums[1] * nums[nums.length - 1]);
        product = Math.max(product, nums[0] * nums[nums.length-2] * nums[nums.length - 1]);


        return product;
    }
}
