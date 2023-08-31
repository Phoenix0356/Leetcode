package medium;

public class maxAbsoluteSum {
    
    public int maxAbsoluteSum(int[] nums) {
        int start=0;
        while (nums[start]==0){
            start++;
            if (start==nums.length) return 0;
        }
        
        int sign=nums[start]/Math.abs(nums[start]);
        return Math.max(count(start,sign,nums),count(start,-sign,nums));
    }
    int count(int start,int sign,int[] nums){
        int pre=0,sum=0;
        for (int i=start;i<nums.length;i++){
            if (sign>0) {
                pre = Math.max(nums[i], pre + nums[i]);
                sum = Math.max(pre, sum);
            } else {
                pre = Math.min(nums[i], pre + nums[i]);
                sum=Math.min(pre,sum);
            }
        }
        return Math.abs(sum);
    }
}
