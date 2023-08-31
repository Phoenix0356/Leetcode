package medium;

import java.util.Arrays;

public class numSubseq {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int count=0,n=nums.length;
        for (int i=0;i<n;i++){
            for (int j=i;j<n;j++){
                if (nums[i]+nums[j]<target){
                    if (j!=n-1)continue;
                }
                count+=j-i+1;
                break;

            }
        }
        return count;
    }
}
