package medium;

import java.util.Arrays;

public class minimumRemoval {
    public long minimumRemoval(int[] beans) {
        long min=Long.MAX_VALUE;
        int indOfMinBean=0;
        Arrays.sort(beans);
        for (int i=0;i<beans.length;i++){
            long minBean=beans[0],temp=0;
            for (int j=0;j<indOfMinBean;j++){
                temp+=beans[j];
                beans[j]=0;
                if (j==indOfMinBean-1)minBean=beans[j+1];
            }
            indOfMinBean++;
            for (int z=indOfMinBean;z<beans.length;z++){
                temp+=beans[z]-minBean;
            }
            min=Math.min(min,temp);
        }
        return min;
    }
}
