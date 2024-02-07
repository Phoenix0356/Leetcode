package medium;

import java.util.PriorityQueue;

public class magicTower {
    public int magicTower(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long hp = 0, move = 0;
        int cnt = 0;
        for (int num : nums) {
            if (num < 0) {
                pq.offer(num);
            }
            hp += num;
            if (hp < 0) {
                int cur = pq.poll();
                hp -= cur;
                move += cur;
                cnt++;
            }
        }
        hp += move;
        return hp < 0 ? -1 : cnt;
    }
}
