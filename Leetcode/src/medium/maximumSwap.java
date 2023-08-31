package medium;
import java.util.Arrays;
public class maximumSwap {
    public int maximumSwap(int num) {
        int n=num;
        int len=String.valueOf(n).length(),ans=0;
        int[] arr = new int[len];
        for (int i=0;i<len;i++){
            arr[i]=num%10;
        }
        Arrays.sort(arr);
        for (int i=0;i<len;i++){
            ans+=arr[i]*Math.pow(10,i);
        }
        return ans;
    }
}
