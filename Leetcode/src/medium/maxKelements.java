package medium;

import java.util.Deque;
import java.util.PriorityQueue;

public class maxKelements {
    public long maxKelements(int[] nums, int k) {
        long ans=0;
        PriorityQueue<Integer> pq=new PriorityQueue<>((o1, o2) -> o2-o1);
        for (int num : nums) pq.offer(num);
        for (int i=0;i<k;i++){
            int max=pq.poll();
            ans+=max;
            pq.offer((max+2)/3);
        }
        return ans;
    }
}
