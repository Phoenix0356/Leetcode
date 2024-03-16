package WeeklyGames;

import java.util.*;

public class g19 {
    public int sumOfEncryptedInt(int[] nums) {
        int sum = 0 ;
        for (int i = 0; i < nums.length; i++) {
            sum+=getNum(nums[i]);
        }
        return sum;
    }

    private int getNum(int n){
        int max = 0, weightsLen = 0;
        int num = 0;
        while (n>0){
            max = Math.max(max,n%10);
            n/=10;
            weightsLen++;
        }
        for (int i = 0; i < weightsLen; i++) {
            num=10*num+max;
        }
        return num;
    }

    public long[] unmarkedSumArray(int[] nums, int[][] queries) {
        long sum = 0;
        int index = 0;
        long[] ans = new long[queries.length];
        boolean[] flag = new boolean[nums.length];
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] == o2[0]) return o1[1] - o2[1];
            return o1[0]-o2[0];
        });

        for (int i = 0;i<nums.length;i++) {
            sum += nums[i];
            pq.offer(new int[]{i,nums[0]});

        }

        for (int[] query:queries){
            int ind = query[0];
            int k = query[1];

            if (!flag[ind]){
                sum -= nums[ind];
                flag[ind] = true;
            }

            while (k > 0&&!pq.isEmpty()) {
                int[] cur = pq.poll();

                if (!flag[cur[1]]) {
                    sum -= cur[0];
                    flag[cur[1]] = true;
                    k--;
                }


            }
            ans[index++] = sum;

        }
        return ans;
    }

    public String minimizeStringValue(String s) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1[1] == o2[1]) return o1[0] - o2[0];
            return o1[1]-o2[1];
        });
        char[] chars = s.toCharArray();
        ArrayList<Integer> indList = new ArrayList<>();
        int[] flag = new int[26];

        for (int i=0;i<chars.length;i++) {
            if (chars[i] == '?') {
                indList.add(i);
                continue;
            }
            flag[chars[i]-'a']++;
        }
        for (int i = 0;i<flag.length;i++){
            pq.offer(new int[]{i,flag[i]});
        }
        char[] arr = new char[indList.size()];
        for (int i =0;i<arr.length;i++){
            if (!pq.isEmpty()){
                int[] cur = pq.poll();
                char c = (char) (cur[0]+'a');
                arr[i] = c;
                pq.offer(new int[]{cur[0],cur[1]+1});
            }
        }
        Arrays.sort(arr);
        int index = 0;
        for (Integer ind : indList) {
            chars[ind] = arr[index++];
        }
        return new String(chars);
    }
}
