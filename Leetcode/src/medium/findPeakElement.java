package medium;

public class findPeakElement {
    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1, m;
        while (l < r) {
            m = (r + l) / 2+1;
            if (nums[m] >= nums[m - 1]) {
                l = m;
            } else {
                r = m-1;
            }
        }
        return l;
    }
}
