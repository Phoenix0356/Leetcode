package WeeklyGames;

import java.util.Arrays;
import java.util.Comparator;

public class g23 {
    public boolean satisfiesConditions(int[][] grid) {
        for (int i = 0; i < grid[0].length; i++) {
            for (int j = 0; j < grid.length - 1; j++) {
                if (grid[j][i] != grid[j + 1][i]) {
                    return false;
                }
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length - 1; j++) {
                if (grid[i][j] == grid[i][j + 1]) {
                    return false;
                }
            }
        }
        return true;
    }

    public int maxPointsInsideSquare(int[][] points, String s) {
        boolean[] set = new boolean[26];
        int cnt = 0;
        int[][] pairs = new int[points.length][3];
        for (int i = 0;i< points.length;i++){
            if (points[i][0]<0) points[i][0] = -points[i][0];
            if (points[i][1]<0) points[i][1] = -points[i][1];
            pairs[i][0] = points[i][0];
            pairs[i][1] = points[i][1];
            pairs[i][2] = s.charAt(i)-'a';
        }
        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int max1 = Math.max(o1[0],o1[1]);
                int max2 = Math.max(o2[0],o2[1]);
                return max1-max2;
            }
        });
        int curLen = 0;
        int same = 0;
        for (int i = 0;i<pairs.length;i++){
            if (set[pairs[i][2]]) {
                if (curLen>=pairs[i][0]&&curLen>=pairs[i][1]){
                    return cnt-same-1;
                }
                return cnt;
            }
            if (curLen>=pairs[i][0]&&curLen>=pairs[i][1]){
                same++;
            }else {
                same = 0;
            }
            curLen = Math.max(pairs[i][0],pairs[i][1]);
            cnt++;
            set[pairs[i][2]] = true;

        }
        return cnt;
    }

    public int minimumSubstringsInPartition(String s) {
        char[] chars = s.toCharArray();
        int ind = 0;
        int cnt = 0;
        int[] a = new int[26];
        for (int i = 0;i< chars.length;i++){
            a[chars[i]-'a']++;
        }
        int min = s.length()+1;
        for (int i =0;i<a.length;i++){
            if (a[i]>0){
                if (min>a[i]) min = a[i];
            }
        }
        for (int i = 1;i<3;i++) {
            int temp = 0;
            while (ind < chars.length) {
                ind = getMaxLen(chars, ind, i) + 1;
                temp++;
            }
            cnt = Math.min(temp,cnt);
        }
        return cnt;
    }

    int getMaxLen(char[] chars,int start,int limit){
        int[] cnt = new int[26];
        for (int i = start;i<chars.length;i++){
            cnt[chars[i]-'a']++;
            if (isBalanced(cnt,limit)){
                return i;
            }
        }
        return 0;
    }

    boolean isBalanced(int[] cnt,int limit){
        int cur = 0;
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i]>0){
                if (cnt[i]!=limit) return false;
            }
        }
        return true;
    }





}
