package easy;

import java.util.ArrayList;
import java.util.List;

public class intersection {
    public List<Integer> intersection(int[][] nums) {
        List<Integer> list = new ArrayList<>();
        int[] arr = new int[1001];
        for (int[] num : nums) {
            for (int n : num) arr[n]++;
        }
        for (int i = 1; i < 1001; i++) {
            if (arr[i] == nums.length) list.add(i);
        }
        return list;
    }
}
