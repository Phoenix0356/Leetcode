package medium;

import java.util.Arrays;

public class maxCoins {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int ans = 0;
        for (int i=0,j=piles.length-1;(i+1)*3<= piles.length;i++,j-=2){
            ans+=piles[j-1];
        }
        return ans;
    }
}
