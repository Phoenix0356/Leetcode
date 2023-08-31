package easy;

import java.util.Arrays;

public class trimMean {
    public double trimMean(int[] arr) {
        double count =arr.length*0.05;
        double sum = 0;
        Arrays.sort(arr);
        for (int i=0;i<arr.length-count;i++){
            if (i<count) {
                arr[i] = 0;
                arr[arr.length - 1 - i] = 0;
            }
            sum+=arr[i];
        }
        return sum/(arr.length-2*count);
    }
}
