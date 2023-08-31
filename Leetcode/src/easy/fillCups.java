package easy;

import java.util.Arrays;

public class fillCups {
    public int fillCups(int[] amount) {
        Arrays.sort(amount);
        int cnt=0;
        while (amount[2]>0){
            amount[2]--;
            if (amount[1]>0) amount[1]--;
            cnt++;

        }
        return cnt;
    }
}
