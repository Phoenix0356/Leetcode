package medium;

import java.util.Arrays;

public class findLeastNumOfUniqueInts {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Arrays.sort(arr);
        int[] kinds=new int[arr.length];
        int ind=0,pre=arr[0],cnt=1;
        kinds[ind]++;
        for (int i=1;i<arr.length;i++){
            if (arr[i]!=pre){
                ind++;
                pre=arr[i];
                cnt++;
            }
            kinds[ind]++;
        }

        ind=kinds.length-ind-1;
        Arrays.sort(kinds);
        if (kinds[0]>k) return cnt;
        else {
            while (k > 0){
                k-=arr[ind++];
                cnt--;
            }
        }
        if (k<0) cnt++;
        return cnt;
    }
}
