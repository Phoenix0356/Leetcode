package medium;

import java.util.Arrays;

public class maximumTastiness {
    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        int left=0,right=price[price.length-1]-price[0];
        while (left<right){
            int mid=(left+right+1)/2;
            if (check(price,mid,k)){
                left=mid;
            }else right=mid-1;
        }
        return left;
    }
    boolean check(int[] price,int mid,int k){
        int cnt=0,prev=Integer.MIN_VALUE / 2;
        for (int p:price){
            if (p-prev>=mid){
                prev=p;
                cnt++;
            }
        }
        return cnt>=k;
    }
}
