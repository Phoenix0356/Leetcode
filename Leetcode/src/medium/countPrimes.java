package medium;

import java.util.Arrays;

public class countPrimes {
    public int countPrimes(int n) {
        int ans=0;
        boolean[] prime = new boolean[n];
        Arrays.fill(prime,true);
        for (int i=2;i<n;i++){
            if (prime[i]){
                ans++;
                if ((long) i*i<n) {
                    for (int j = i*i;j<n;j+=i){
                        prime[j]=false;
                    }
                }
            }
        }
        return ans;
    }

}
