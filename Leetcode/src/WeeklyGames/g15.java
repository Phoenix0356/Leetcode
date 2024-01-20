package WeeklyGames;

import java.lang.reflect.Array;
import java.util.Arrays;

public class g15 {
    public int missingInteger(int[] nums) {
        if (nums.length==1) return nums[0]+1;
        int sum = nums[0]+1,cnt = 0;
        boolean[] flag=new boolean[51];
        boolean is=true;
        for (int i=1;i< nums.length;i++){
            flag[nums[i]]=true;
            if (nums[i]-nums[i-1]==1&&is){
                cnt++;
            }else {
                is = false;
                if (cnt>0) {
                    sum = Math.max(sum, count(nums[i - 1], nums[0]));
                    cnt = 0;
                }
            }
        }
        if (is) sum = Math.max(sum, count(nums[nums.length - 1], nums[0]));
        System.out.println(sum);
        if (sum>50) return sum;
        for (int i=sum;i< flag.length;i++){
            if (!flag[i]) return i;
        }
        return 51;
    }
    private int count(int num,int start){
        int sum=0;
        for (int i=num;i>=start;i--){
            sum+=i;
        }
        return sum;
    }

    public int minOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int max = Math.max(nums[nums.length - 1], k), cnt = 0;
        int len = 0;
        while (max > 0) {
            max /= 2;
            len++;
        }
        int[] weights = new int[len];
        for (int num : nums) {
            int cur = num, weigh = 0;
            while (cur > 0) {
                if (((cur % 2) & 1) == 1) weights[weigh]++;
                weigh++;
                len++;
                cur /= 2;
            }
        }
        for (int weight : weights) {
            if ((weight % 2) != (k & 1)) {
                cnt++;
            }
            k /= 2;
        }
        return cnt;
    }
//    public int minimumOperationsToMakeEqual(int x, int y) {
//        int cnt=0;
//        int max=Math.max(x,y);
//        int min=Math.min(x,y);
//        if (max/5<min) return max-min;
//        while (max>min){
//            System.out.println(max);
//            if (max%11==0){
//                while ((max/11)>min) {
//                    max/=11;
//                    cnt++;
//                }
//            }
//            if (max%5==0){
//                while ((max/5)>min) {
//                    max/=5;
//                    cnt++;
//                }
//            }
//            else {
//                max--;
//                cnt++;
//            }
//        }
//
//
//        return max-min+cnt;
//    }
}
