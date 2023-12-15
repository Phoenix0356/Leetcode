package WeeklyGames;

import java.util.*;

public class g13 {
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        return new int[]{find(nums1,nums2),find(nums2,nums1)};
    }
    int find(int[] nums1,int[] nums2){
        int cnt=0;
        for (int k : nums1) {
            for (int i : nums2) {
                if (k == i) {
                    cnt++;
                    break;
                }
            }
        }
        return cnt;
    }

    public int removeAlmostEqualCharacters(String word) {
        int ans=0,cnt=1,pre=word.charAt(0);
        for (int i=1;i<word.length();i++){
            if (word.charAt(i)==pre||Math.abs(word.charAt(i)-pre)==1){
                cnt++;
                pre=word.charAt(i);
                System.out.println(cnt);
            }else {
                ans+=cnt/2;
                cnt=1;
            }
        }
        ans+=cnt/2;
        return ans;
    }

    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        Queue<Integer> queue=new LinkedList<>();
        int max=0;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
            queue.offer(num);
            if (map.getOrDefault(num, 0) > k) {
                if (!queue.isEmpty()) {
                    int drop = queue.poll();
                    map.put(drop, map.get(drop) - 1);
                    while (drop != num) {
                        drop = queue.poll();
                        map.put(drop, map.get(drop) - 1);
                    }
                }
            }
            max = Math.max(max, queue.size());

        }
        return Math.max(max,queue.size());
    }

    public int numberOfSets(int n, int maxDistance, int[][] roads) {

        ArrayList<int[]> list=new ArrayList<>();
        for (int i=0;i<n;i++){
            list.add(countDist(n,i,roads));
            for (int k:list.get(i)) System.out.print(k+" ");
            System.out.println();
        }
        int[] set=new int[n];
        int count=0;
        int sum=1;
        for (int i=1;i<=n;i++) sum+=sum(n,i);

        for (int[] dis:list){
            for (int j=0;j<dis.length;j++){
                if (dis[j]==-1) continue;
                if (dis[j]<maxDistance&&set[dis[j]]==0) {
                    set[dis[j]]=1;
                    count++;
                }
            }
        }
        int remain=0;
        for (int i=1;i<=count;i++) remain+=sum(count,i);
        System.out.println(count);
        return sum-remain;

    }
    public int sum(int n,int up){
        int upper=1,down=1;
        for (int i=0;i<up;i++){
            upper*=n;
            n--;
            down*=up;
            up--;
        }
        return upper/down;
    }
    public int[] countDist(int n,int cur,int[][] roads){
        int[] dis = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[cur] = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int[] road : roads) {
                if (dis[road[0]] != Integer.MAX_VALUE && dis[road[0]] + road[2] < dis[road[1]]) {
                    dis[road[1]] = dis[road[0]] + road[2];
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (dis[i] == Integer.MAX_VALUE) {
                dis[i] = -1;
            }
        }
        dis[cur]=-1;
        return dis;
    }
}
