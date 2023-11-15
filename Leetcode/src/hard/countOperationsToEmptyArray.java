package hard;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class countOperationsToEmptyArray {
    public long countOperationsToEmptyArray(int[] nums) {
        int n = nums.length;
        var id = new Integer[n];
        for (int i = 0; i < n; ++i)
            id[i] = i;
        Arrays.sort(id, Comparator.comparingInt(i -> nums[i]));

        long ans = n; // 先把 n 计入答案
        for (int k = 1; k < n; ++k)
            if (id[k] < id[k - 1]) // 必须多走一整圈
                ans += n - k; // 减去前面删除的元素个数
        return ans;
    }
}
