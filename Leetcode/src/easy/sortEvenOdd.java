package easy;

import java.util.Arrays;

public class sortEvenOdd {
    public int[] sortEvenOdd(int[] nums) {
        int[] arrEven=new int[nums.length%2==0? nums.length/2: nums.length/2+1];
        int[] arrOdd=new int[nums.length/2];
        int[] res=new int[nums.length];
        int ind1=0,ind2=0,ind3=0,ind4=0;
        int z=1;int j=1;
        for(int c:nums){
            if(j==1){
            arrEven[ind1++]=c;
            }else{
                arrOdd[ind2++]=c;
            }
            j=-j;
        }
        Arrays.sort(arrEven);
        Arrays.sort(arrOdd);
        for(int i=0;i<nums.length;i++){
            if(z==1) {
                res[i] =arrEven[ind3++];
            }else{
                res[i]=arrOdd[arrOdd.length-ind4++-1];
            }
            z=-z;
        }
        return res;
    }
}
