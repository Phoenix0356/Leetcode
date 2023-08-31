package easy;

import java.util.HashMap;
import java.util.Map;

public class countKDifference {
    public int countKDifference(int[] nums, int k) {
        int count=0;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j< nums.length;j++){
                if(k==nums[i]-nums[j]){
                    count++;
                }
            }
        }
    return count;
    }
    public int countKDifference2(int[] nums, int k) {
        Map<Integer,Integer> myMap=new HashMap<>();
        int res=0;
        for(int num:nums){
            myMap.put(num,myMap.getOrDefault(num,0)+1);
            res+=myMap.getOrDefault(num-k,0)+myMap.getOrDefault(num+k,0);
        }
        return res;
    }
}
