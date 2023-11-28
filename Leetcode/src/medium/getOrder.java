package medium;

import java.util.*;

public class getOrder {
    public int[] getOrder(int[][] tasks) {
        int[][] tt = new int[tasks.length][3];
        for (int i = 0; i < tasks.length; ++i) {
            tt[i][0] = tasks[i][0];
            tt[i][1] = tasks[i][1];
            tt[i][2] = i;
        }
        Arrays.sort(tt, (a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[2] - b[2] : a[1] - b[1]);

        int curTime = Integer.MIN_VALUE;
        int p = 0;
        int[] res = new int[tt.length];

        for (int i = 0; i < tt.length; ++i) {
            while (p < tt.length && (tt[p][0] <= curTime || q.isEmpty())) {
                curTime = Math.max(tt[p][0], curTime);
                q.offer(tt[p]);
                p++;
            }
            int[] t = q.poll();
            curTime = curTime + t[1];
            res[i] = t[2];

        }
        return res;
    }
}
