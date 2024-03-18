package medium;

import java.util.Arrays;

public class coinChange {
    public int coinChange(int[] coins, int amount) {
        long[] arr = new long[amount+1];
        Arrays.fill(arr,Long.MAX_VALUE);
        arr[0] = 0;
        for(int i = 1;i<amount+1;i++){
            for(int coin:coins){
                if(i>=coin){
                    arr[i] = Math.min(arr[i],arr[coin]+arr[i-coin]);
                }
            }
        }
        return (int) arr[amount];
    }
}
