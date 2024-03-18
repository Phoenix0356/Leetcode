package medium;

import java.util.ArrayDeque;
import java.util.Scanner;

public class nextGreaterElements {
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 2 * len - 1; i >= 0; i--) {
            int cur = nums[i % len];
            while (!stack.isEmpty() && cur >= stack.peek()) {
                stack.pop();
            }
            ans[i % len] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(cur);

        }
        return ans;
    }
}
