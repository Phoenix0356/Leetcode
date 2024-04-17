package WeeklyGames;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;

public class g21 {
    public int scoreOfString(String s) {
        char[] chars = s.toCharArray();
        int score=0;
        for (int i = 1;i<chars.length;i++){
            score+=Math.abs(chars[i]-chars[i-1]);
        }
        return score;
    }

    public int minRectanglesToCoverPoints(int[][] points, int w) {
        if (w == 0) return points.length;
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0]==o2[0]) return o1[1]-o2[1];
                return o1[0]-o2[0];
            }
        });
        long start = points[0][0];
        int sum=1;

        for (int i = 1;i<points.length;i++){
            int curX = points[i][0];
            if (curX-start>w){
                sum++;
                start = curX;
            }
        }
        return sum;
    }

    int[] answer;
    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        answer = new int[n];
        Arrays.fill(answer,-1);
        int[][] adjMatrix = new int[n][n];
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int len = edge[2];
            int curLen = adjMatrix[u][v];
            if (curLen==0||curLen>len) {
                adjMatrix[u][v] = len;
                adjMatrix[v][u] = len;
            }
        }
        boolean[] flag = new boolean[n];
        dfs(adjMatrix,disappear,0,0,flag);
        return answer;
    }

    void dfs(int[][] adjMatrix,int[] disappear,int curTime,int curNode,boolean[] flag){
        if (curTime>=disappear[curNode]) {
            return;
        }
        if (answer[curNode]!=-1&&curTime>=answer[curNode]){
            return;
        }
        answer[curNode] = curTime;
        for (int i = 0;i< adjMatrix.length;i++){
            if (adjMatrix[curNode][i]==0||flag[i]) continue;
            flag[i] = true;
            dfs(adjMatrix, disappear, curTime + adjMatrix[curNode][i], i,flag);
            flag[i] = false;
        }
    }
}
