package medium;

import java.util.Arrays;
import java.util.Comparator;

public class miceAndCheese {
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int l=reward1.length;
        int[] map=new int[l];
        int sum=0;
        for (int i=0;i<l;i++){
            map[i]=reward1[i]-reward2[i];
            sum+=reward2[i];
        }
        Arrays.sort(map);

        for (int i=l-1;i>=l-k;i--){
            sum+=map[i];
        }
        return sum;
    }
}
