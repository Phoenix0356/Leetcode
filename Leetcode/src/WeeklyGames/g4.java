package WeeklyGames;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class g4 {
    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int ans=0;
        for (int n:hours){
            if (n>=target) ans++;
        }
        return ans;
    }
    public int countCompleteSubarrays(int[] nums) {
        HashSet<Integer> hs=new HashSet<>();
        HashSet<Integer> hs2=new HashSet<>();

        int l=0,ans=0,min=Integer.MAX_VALUE,start=0;
        for (int num : nums) hs.add(num);
        //System.out.println(hs.size());
        for (int i=0;i<nums.length;i++){
            for (int j=i;j< nums.length;j++){
                hs2.add(nums[j]);
                if (hs2.size()==hs.size()){
                    ans+=nums.length-j;
                    //System.out.println(ans);
                    break;
                }
            }
            hs2.clear();
        }
        return ans;
    }
}
