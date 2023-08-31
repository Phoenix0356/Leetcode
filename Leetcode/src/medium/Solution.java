package medium;

import java.util.ArrayList;
import java.util.Random;

public class Solution {
    int[] nums;
    public Solution(int[] nums) {
        this.nums=nums;
    }

    public int pick(int target) {
        ArrayList<Integer> list=new ArrayList<>();
       for (int i=0;i< nums.length;i++){
           if (nums[i]==target){
               list.add(i);
           }
       }
        Random r=new Random();
       int ind=r.nextInt(list.size());
       return list.get(ind);
    }
}
