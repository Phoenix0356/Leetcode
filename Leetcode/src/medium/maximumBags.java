package medium;

import java.util.Arrays;

public class maximumBags {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        for (int i=0;i< capacity.length;i++) capacity[i]-=rocks[i];
        int cnt=0;
        Arrays.sort(capacity);
        for (int n:capacity){
            additionalRocks-=n;
            cnt++;
            if (additionalRocks<0){
                cnt--;
                break;
            }

        }
        return cnt;
    }
}
