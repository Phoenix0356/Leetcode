package easy;

import java.util.ArrayDeque;
import java.util.HashMap;

public class nextGreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map = new HashMap<>();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int[] ans = new int[nums1.length];
        for(int i = nums2.length-1;i>=0;i--){
            int cur = nums2[i];
            while(!stack.isEmpty()&&cur>stack.peek()){
                stack.pop();
            }

            map.put(cur,stack.isEmpty()?-1:stack.peek());
            stack.push(cur);
        }

        for(int i = 0;i<nums1.length;i++){
            ans[i] = map.get(nums1[i]);
        }
        return ans;
    }
}
