package WeeklyGames;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class g11 {
    public int sumCounts(List<Integer> nums) {
        long cnt=nums.size();

        HashSet<Integer> set=new HashSet<>();
        for (int i=0;i<nums.size();i++){
            set.clear();
            set.add(nums.get(i));
            for (int j=i+1;j<nums.size();j++){
                set.add(nums.get(j));
                cnt+= (long) set.size() *set.size();
            }
        }
        return (int) cnt%1000000007;
    }
    public int minChanges(String s) {
        int cnt=0;
        for (int i=0;i<s.length();i+=2){
            if (s.charAt(i)!=s.charAt(i+1)) cnt++;
        }
        return cnt;
    }


}
