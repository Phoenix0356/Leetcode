package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class maxTaxiEarnings {

    public long maxTaxiEarnings(int n, int[][] rides) {
        HashMap<Integer, ArrayList<int[]>> map=new HashMap<>();
        for (int[] ride:rides){
            map.putIfAbsent(ride[1],new ArrayList<>());
            map.get(ride[1]).add(ride);
        }
        long[] dp=new long[n+1];
        for (int i=1;i<=n;i++){
            dp[i]=dp[i-1];
            if (map.containsKey(i)){
                for (int[] ride:map.get(i)){
                    dp[i]=Math.max(dp[i],dp[ride[0]]+ride[1]-ride[0]+ride[2]);
                }
            }
        }
        return dp[n];
    }
}
