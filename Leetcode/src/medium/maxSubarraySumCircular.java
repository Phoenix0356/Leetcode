package medium;

public class maxSubarraySumCircular {
    public int maxSubarraySumCircular(int[] nums) {
        int sum=Integer.MIN_VALUE,pre=0;
        boolean count=true;
        for (int num : nums) {
            pre = Math.max(num, pre + num);
            sum = Math.max(sum, pre);
        }
        return sum;
    }
}
