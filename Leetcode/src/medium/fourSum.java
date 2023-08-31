package medium;

import java.util.ArrayList;
import java.util.List;

public class fourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list=new ArrayList<>();
        int len= nums.length;
        for (int i=0;i< len;i++){
            for (int j=i+1;j<len;j++){
                for (int k=j+1;k<len;k++){
                    for (int m=k+1;m<len;m++){
                        if (nums[i]+nums[j]+nums[k]+nums[m]==target){
                            List<Integer> l=new ArrayList<>();
                            l.add(nums[i]);
                            l.add(nums[j]);
                            l.add(nums[k]);
                            l.add(nums[m]);
                            list.add(l);
                        }
                    }
                }
            }
        }
        return list;
    }
}
