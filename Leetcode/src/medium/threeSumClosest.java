package medium;

import java.util.Arrays;

public class threeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        int sum=0,l= nums.length,diff=Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i=0;i<l;i++){
            int start=i+1,end=l-1;
            while (start<end){
                int temp=nums[i]+nums[start]+nums[end];
                if (Math.abs(temp-target)<diff){
                    sum=temp;
                    diff=Math.abs(temp-target);
                }
                if (temp>target) end--;
                else if (temp<target) start++;
                else return target;

            }
        }
        return sum;
    }
}
