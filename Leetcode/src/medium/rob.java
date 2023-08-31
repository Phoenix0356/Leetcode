package medium;

public class rob {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp=new int[nums.length+1];
        dp[0]=0;
        dp[1]=nums[0];
        for (int i=2;i< nums.length+1;i++){
            dp[i]=Math.max(dp[i-2]+nums[i-1],dp[i-1]);
        }
        return dp[dp.length-1];
    }
    public int rob2(int[] nums) {
        int len=nums.length;
        return Math.max(robRange(nums,1,len-1),robRange(nums,0,len-2));
    }
    public int robRange(int[] nums,int start,int end){
        int first = nums[start], second = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i <= end; i++) {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }
        return second;
    }
}
