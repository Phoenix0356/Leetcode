package easy;

public class findSpecialInteger {
    public int findSpecialInteger(int[] arr) {
        if (arr.length==1) return arr[0];
        int count=1;
        for (int i=0;i<arr.length-1;i++){
            if (arr[i]!=arr[i+1]) count=1;
            count++;
            if (4*count>arr.length) return arr[i];

        }
        return 0;
    }
}
