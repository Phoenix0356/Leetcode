package easy;

import java.util.*;

public class arrayRankTransform {
    public int[] arrayRankTransform(int[] arr) {
        int[] clone = arr.clone();
        Arrays.sort(clone);
        Map<Integer, Integer> map = new HashMap<>();
        int n = arr.length, idx = 0;
        for (int i : clone) {
            if (!map.containsKey(i)) map.put(i, ++idx);
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) ans[i] = map.get(arr[i]);
        return ans;
    }
}
