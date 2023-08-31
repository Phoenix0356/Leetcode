package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class findDuplicates {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Arrays.sort(nums);
        int count=1;
       for (int i=1;i<nums.length;i++){
           if (nums[i-1]==nums[i]){
               count++;
           }else {
               if (count>1) res.add(nums[i-1]);
               count=1;
           }
       }
       if (count>1) res.add(nums[nums.length-1]);
        return res;
    }
}
