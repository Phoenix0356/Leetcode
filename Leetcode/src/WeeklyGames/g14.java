package WeeklyGames;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class g14 {
    public int incremovableSubarrayCount(int[] nums) {
        int sum=0;
        for (int i=0;i<nums.length;i++){
            for (int j=i;j<nums.length;j++){
                ArrayList<Integer> list=new ArrayList<>();
                for (int k=0;k<nums.length;k++){
                    if (k<=j&&k>=i) continue;
                    list.add(nums[k]);
                }
                if (isIncrease(list)) sum++;
            }
        }
        return sum;
    }

    boolean isIncrease(ArrayList<Integer> list){
        if (list.isEmpty()) return true;
        int cur = list.get(0);
        for (int i=1;i< list.size();i++){
            if (list.get(i)<=cur) return false;
            cur = list.get(i);
        }
        return true;
    }

    public long largestPerimeter(int[] nums) {
        if (nums.length<3) return -1;
        Arrays.sort(nums);
        long max=0,sum=nums[0]+nums[1];
        boolean flag=false;
        for (int i=0;i< nums.length;i++){
            if (nums[i]<sum){
                max = sum;
                flag=true;
            }
            sum+=nums[i];
        }
        return flag?max:-1;
    }
}
