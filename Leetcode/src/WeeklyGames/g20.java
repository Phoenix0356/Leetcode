package WeeklyGames;

import java.util.Arrays;

public class g20 {
    public int minimumSubarrayLength(int[] nums, int k) {

        int cur = nums[0], cnt = Integer.MAX_VALUE;
        int left = 0,right = 1;
        if (cur>k) return 1;
        while (right < nums.length){

            cur|=nums[right];

            if (cur<k){
                right++;
            }else {
                if (left == right) return 1;
                cnt = Math.min(cnt,right-left+1);
                left++;
                int temp = nums[left];
                for (int i = left+1; i <= right ; i++) {
                    temp|=nums[i];
                }
                cur = temp;
            }
        }
        return cnt == Integer.MAX_VALUE?-1:cnt;
    }

    public int minimumSubarrayLength2(int[] nums, int k) {
        int[] weights = new int[1000];
        int cur = nums[0], cnt = Integer.MAX_VALUE;
        int left = 0,right = 0;
        if (cur>k) return 1;
        weights = d2b(weights,cur,true);
        while (left<=right&&right < nums.length){

            cur = b2d(weights);

            if (cur<k){
                weights = d2b(weights,nums[right],true );
                right++;
            }else {
                if (left == right) return 1;
                cnt = Math.min(cnt,right-left+1);
                weights = d2b(weights,nums[left],false );
                left++;
            }

        }
        return cnt == Integer.MAX_VALUE?-1:cnt;
    }

    int[] d2b(int[] weights,int num,boolean isAdd){
        int ind = 0;
        while (num>0){
            if (num%2 == 1) {
                if (isAdd) weights[ind]++;
                else weights[ind]--;
            }
            num/=2;
            ind++;
        }
        return weights;
    }

    int b2d(int[] weights){
        int num = 0;
        for (int i = 0; i < weights.length; i++) {
            if (weights[i]>0){
                num+=(1<<i);
            }
        }
        return num;
    }

    public int minimumLevels(int[] possible) {
        int sum = 0;
        for (int i : possible) {
            if (i == 0) sum--;
            else sum++;
        }
        int me = 0,rural = sum;
        for (int i = 0; i < possible.length-1; i++) {
            if (possible[i] == 0) {
                me++;
                rural--;
            }else {
                me--;
                rural++;
            }
            if (me>rural) return i;

        }
        return -1;
    }

}
