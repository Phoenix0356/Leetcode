package hard;

import java.util.LinkedList;

public class maxSlidingWindow {
    public class monotonicQueue{
        LinkedList<Integer> list = new LinkedList<>();
        void push(Integer t){
            while (!list.isEmpty()&&t>list.getLast()) {
                list.removeLast();
            }
            list.addLast(t);
        }

        Integer max(){
            return list.getFirst();
        }

        void pop(int n){
            if (n == list.getFirst()){
                list.pollFirst();
            }
        }

    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        monotonicQueue mq = new monotonicQueue();
        int[] ans = new int[nums.length-k+1];
        for(int i = 0;i<k-1;i++){
            mq.push(nums[i]);
        }
        for(int i = 0;i+k-1<nums.length;i++){
            mq.push(nums[i+k-1]);
            ans[i] = mq.max();
            mq.pop(nums[i]);
        }

        return ans;
    }
}
