package easy;

public class findLengthOfLCIS {
    public int findLengthOfLCIS(int[] nums) {
        int left=0,right=1,sum=1;
        for (;right< nums.length;right++){
            if (nums[left]>=nums[right]){
                sum=Math.max(sum,right-left);
                left=right;
            }
        }
        return Math.max(sum,right-left);
    }
}
