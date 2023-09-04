package easy;

import java.util.Arrays;
import java.util.HashSet;

public class minNumber {
    public int minNumber(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        HashSet<Integer> set=new HashSet<>();
        for (int n:nums2) set.add(n);
        for (int n:nums1){
            if (set.contains(n)) return n;
        }
        return nums1[0]>nums2[0]?nums1[0]*10+nums2[0]:nums2[0]*10+nums1[0];
    }
}
