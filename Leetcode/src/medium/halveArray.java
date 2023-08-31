package medium;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class halveArray {
    public int halveArray(int[] nums) {
        PriorityQueue<Double> pq=new PriorityQueue<>(Collections.reverseOrder());
        double sum=0;
        int cnt=0;
        for (int num : nums) {
            pq.offer((double) num);
            sum += num;
        }
        double temp=sum,limit=sum/2;
        while (temp>limit){
           double max=pq.poll()/2;
           temp-=max;
           pq.offer(max);
           cnt++;
        }
        return cnt;
    }
}
