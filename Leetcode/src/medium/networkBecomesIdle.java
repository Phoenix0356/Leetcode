package medium;

import java.util.Arrays;

public class networkBecomesIdle {
    public int networkBecomesIdle(int[][] edges, int[] patience) {
        int n=edges.length,time=0;
        int[][] graph=new int[n+1][n+1];
        boolean[] flag=new boolean[n+1];
        for (int i=0;i<n;i++){
            int serial=0;
            for (int count=0;count<n;count++) {
                for (int[] channal:edges){
                    if (graph[i][count] == channal[0]&&flag[channal[1]]==false) {
                        graph[i + 1][serial++] = channal[1];
                        flag[channal[1]]=true;
                    }
                }
            }
        }
        for (int i=1;i<n+1;i++){
            for (int j=0;j<n;j++){
                int dis=i,numOfSend=0,timeGap=0;
                if (graph[i][j]!=0){
                        timeGap=patience[graph[i][j]];
                        numOfSend=(2*dis-1)/patience[graph[i][j]];
                        time=Math.max(time,numOfSend*timeGap+2*dis);
                }
            }
        }
        return time+1;
    }
}
