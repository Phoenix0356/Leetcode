package easy;

import java.util.Arrays;
import java.util.HashSet;

public class distinctAverages {
    public int distinctAverages(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        Arrays.sort(nums);
        int count=0;
        for (int i=0;i< nums.length/2+1;i++){
            int average=nums[i]+nums[nums.length-1-i];
            if (set.add(average))count++;
        }
        return count;
    }
}
