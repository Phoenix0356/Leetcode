package medium;

import java.util.Arrays;
import java.util.HashSet;

public class eliminateMaximum {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int[] order=new int[dist.length];
        for (int i=0;i<dist.length;i++) order[i]=dist[i]%speed[i]==0?dist[i]/speed[i]:dist[i]/speed[i]+1;
        Arrays.sort(order);

        for (int i=0;i<order.length;i++) if (i>=order[i])return i;


        return dist.length;
    }
}
