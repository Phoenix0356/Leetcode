package easy;

import java.util.HashMap;
import java.util.Map;

public class repeatedNTimes {
    public int repeatedNTimes(int[] nums) {
        int n=0,le=0;
        int[] count=new int[nums.length];
        for (int i=0;i<nums.length;i++){
            int l=2;
            count[nums[i]]++;
            l*=++n;
            if (l!=nums.length) {
                continue;
            } else {
                le=n;
            }
        }
        for (int i=1;i<count.length;i++){
            if (count[i]==le){
                le=i;
                break;
            }
        }
        return le;
    }
}
