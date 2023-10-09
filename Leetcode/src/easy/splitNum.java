package easy;

import java.util.ArrayList;
import java.util.Arrays;

public class splitNum {
    public int splitNum(int num) {
        ArrayList<Integer> list=new ArrayList<>();
        while (num>0){
            list.add(num%10);
            num/=10;
        }
        int[] arr=new int[list.size()];
        for (int i=0;i<list.size();i++) arr[i]=list.get(i);
        Arrays.sort(arr);
        int n1=0,n2=0;
        for (int i=0;i< arr.length;i++){
            int a=i/2;
            int n=(int) Math.pow(10, a);
            if (i%2==0) {
                n1 += arr[arr.length-i-1] * n;
            }else {
                n2+=arr[arr.length-1-i]*n;
            }
        }
        return n1+n2;
    }
}
