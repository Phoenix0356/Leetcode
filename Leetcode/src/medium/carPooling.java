package medium;

import java.util.Arrays;
import java.util.Comparator;

public class carPooling {
    public boolean carPooling(int[][] trips, int capacity) {

        int[] arr=new int[1001];

        for (int[] nums:trips){
            arr[nums[1]]+=nums[0];
            arr[nums[2]]-=nums[0];
        }
        int count=0;
        for (int i=0;i<1000;i++){
            count+=arr[i];
            if (count>capacity)return false;
        }
        return true;
    }
}
