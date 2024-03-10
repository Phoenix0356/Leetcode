package WeeklyGames;

import java.util.*;

public class g18 {
    public int minOperations(int[] nums, int k) {
        int cnt = 0;
        for (int num : nums) {
            if (num < k) cnt++;
        }
        return cnt;
    }
    public int minOperations2(int[] nums, int k) {
        int ans = 0;
        PriorityQueue<Long> pq = new PriorityQueue<>(new Comparator<Long>() {
            @Override
            public int compare(Long o1, Long o2) {
                return (int) (o1-o2);
            }
        });

        for (int num : nums) {
            pq.offer((long) num);
        }

        while (pq.size()>1&&pq.peek()<k){
            long x = pq.poll();
            if (pq.isEmpty()) break;
            long y = pq.poll();
            long cur = x*2+y;
            pq.offer(cur);
            ans++;
        }
        return ans;
    }
    public int[] countPairsOfConnectableServers(int[][] edges, int signalSpeed) {
        int n = edges.length+1;
        int[] count = new int[n];
        boolean[][] isPublicLine = new boolean[n][n];
        Map<Integer,List<Integer>> distMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int[] dis = new int[n];
            Arrays.fill(dis,-1);
            dis[i] = 0;
            for (int j = 0; j < n; j++) {
                for (int[] edge : edges) {
                    int x = edge[0];
                    int y = edge[1];
                    int weight = edge[2];
                    if (dis[x] != -1) {
                        dis[y] = dis[x]+weight;
                    }
                    if (dis[y] != -1) {
                        dis[x] = dis[y]+weight;
                    }
                }
            }
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (j==i) list.add(-1);
                list.add(dis[j]);
            }
            distMap.put(i,list);


        }

        for (int i = 0;i<n;i++) {
            List<Integer> list = distMap.get(i);
            for (int j = 0; j < i; j++) {
                if (list.get(j)%signalSpeed==0){
                    for (int k = i+1 ; k < n; k++) {
                        if (list.get(k) % signalSpeed == 0) count[i]++;
                    }
                }
            }
        }
        return count;
    }
}
