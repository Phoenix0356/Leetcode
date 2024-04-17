package WeeklyGames;

import java.util.Arrays;
import java.util.List;

public class g10 {
    public int minimumRightShifts(List<Integer> nums) {
        int cur=nums.get(0),max=nums.get(0);
        int ind=0;
        boolean isFind=false;
        for (int i=1;i<nums.size();i++){
            if (nums.get(i)<cur) {
                if (!isFind) {
                    ind = i;
                    isFind = true;
                }else return -1;
            }else {
                if (nums.get(i)>max&&isFind) return -1;
            }
            cur=nums.get(i);
            max=Math.max(max, nums.get(i));
        }
        return isFind?nums.size()-ind:0;
    }
//    public int minLengthAfterRemovals(List<Integer> nums) {
//        if (nums.size()==1) return 1;
//        int ind=0,cnt=1;
//        int[] arr=new int[nums.size()];
//        for (int i=1;i<nums.size();i++){
//            if (nums.get(i-1)<nums.get(i)) {
//                arr[ind++]=cnt;
//                cnt=0;
//            }
//            cnt++;
//        }
//        arr[ind]=cnt;
//        cnt=0;
//        Arrays.Sort(arr);
//        for (int i=0;i<arr.length;i++){
//            if (arr[i]==0||i==arr.length-1) continue;
//            for (int j=i;j<arr.length;j++){
//                arr[j]-=arr[i];
//            }
//        }
//        return nums.size()-cnt;
//    }
}
