package medium;

import java.util.*;

public class advantageCount {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            List<Integer> list = map.getOrDefault(nums2[i], new ArrayList<>());
            list.add(i);
            map.put(nums2[i], list);
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] ans = new int[n];
        for (int l1 = 0, l2 = 0, r2 = n - 1; l1 < n; l1++) {
            int t = nums1[l1] > nums2[l2] ? l2 : r2;
            List<Integer> list = map.get(nums2[t]);
            int idx = list.remove(list.size() - 1);
            ans[idx] = nums1[l1];
            if (t == l2) l2++;
            else r2--;
        }
        return ans;
    }
}
