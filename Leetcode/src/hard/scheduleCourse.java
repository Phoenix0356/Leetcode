package hard;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class scheduleCourse {
    public int scheduleCourse(int[][] courses) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        Arrays.sort(courses, (o1, o2) -> {
            if (o1[1]==o2[1]) return o1[0]-o2[0];
            return o1[1]-o2[1];
        });
        int day=0;
        for (int[] course:courses){
            int d=course[0],limit=course[1];
            if (day+d<=limit){
                pq.offer(d);
                day+=d;
            }else {
                if (!pq.isEmpty()&&pq.peek()>d){
                    day-=pq.poll();
                    day+=d;
                    pq.offer(d);
                }

            }
        }
        return pq.size();
    }
}
