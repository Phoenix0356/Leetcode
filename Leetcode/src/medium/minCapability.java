package medium;

import java.util.Arrays;

public class minCapability {
    public int minCapability(int[] nums, int k) {
        int min=Arrays.stream(nums).min().getAsInt();
        int max=Arrays.stream(nums).max().getAsInt();
        while (min<=max){
            int middle=(min+max)/2;
            int cnt=0;
            boolean isVisited=false;
            for (int n:nums){
                if (n<=middle&&!isVisited){
                    isVisited=true;
                    cnt++;
                }else isVisited=false;
            }
            if (cnt>=k){
                max=middle-1;
            }else {
                min=middle+1;
            }
        }
        return min;
    }
}
