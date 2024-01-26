package WeeklyGames;

import javax.swing.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class g17 {
    public int minimumCost(int[] nums) {
        if (nums.length == 3) return nums[0]+nums[1]+nums[2];
        int cnt=0;
        int price = nums[0];
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        map.put(nums[0],map.get(nums[0])-1);
        Arrays.sort(nums);
        for (int num : nums) {
            if (map.get(num) > 0) {
                map.put(nums[0],map.get(nums[0])-1);
                price += num;
                cnt++;
            }
            if (cnt==2) break;
        }
        return price;

    }
    public boolean canSortArray(int[] nums) {
        for (int i=0;i< nums.length - 1;i++){
           for (int j=0;j< nums.length - i - 1;j++){
                if (nums[j]>nums[j+1]&&count_one_in_decimal(nums[j])==count_one_in_decimal(nums[j+1])){
                    int temp = nums[j+1];
                    nums[j+1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        return is_ordered(nums);
    }
    private boolean is_ordered(int[] nums){
        for (int i=1;i< nums.length;i++){
            if (nums[i-1]>nums[i]) return false;
        }
        return true;
    }
    private int count_one_in_decimal(int num){
        int cnt=0;
        while (num>0) {
            if (num%2>0){
                cnt++;
            }
            num/=2;
        }
        return cnt;
    }
}
