package easy;

public class longestAlternatingSubarray {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int n = nums.length;
        int len = 0;
        int i = 0;
        while (i < n) {
            if (nums[i] <= threshold && nums[i] % 2 == 0) {
                int tempLength = 0;
                int tempRight = i + 1;
                while (tempRight < n && nums[tempRight] <= threshold &&
                        nums[tempRight - 1] % 2 != nums[tempRight] % 2) {
                    tempRight++;
                }
                tempLength = tempRight - i;
                len = Math.max(len, tempLength);
                i = tempRight;
            } else {
                i++;
            }
        }
        return len;
    }
}
