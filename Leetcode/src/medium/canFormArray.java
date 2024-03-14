package medium;

import java.util.ArrayList;
import java.util.Arrays;

public class canFormArray {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        int n = arr.length, m = pieces.length;
        Arrays.sort(pieces, (a, b)->a[0]-b[0]);
        for (int i = 0; i < n; ) {
            int l = 0, r = m - 1;
            while (l < r) {
                int mid = l + r + 1 >> 1;
                if (pieces[mid][0] <= arr[i]) l = mid;
                else r = mid - 1;
            }
            int len = pieces[r].length, idx = 0;
            while (idx < len && pieces[r][idx] == arr[i + idx]) idx++;
            if (idx == len) i += len;
            else return false;
        }
        return true;
    }
}
