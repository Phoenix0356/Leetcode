package hard;

import java.util.*;

public class BlackList {

    int validLen;
    int[] arr;

    Random random = new Random();
    public BlackList(int n, int[] blacklist) {
        arr = new int[n];
        validLen = n;

        for (int i=0;i<n;i++){
            arr[i] = i;

        }

        for (int i : blacklist) {

            int temp = arr[validLen-1];
            arr[validLen-1] = i;
            arr[i] = temp;

            validLen--;
        }
    }

    public int pick() {
        return arr[random.nextInt(validLen)];
    }
}
