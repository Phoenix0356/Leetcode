package medium;

import java.util.*;

public class reachableNodes {
    int cnt = 0;

    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        boolean[] isRestricted = new boolean[n];
        for (int x : restricted) {
            isRestricted[x] = true;
        }

        List<Integer>[] g = new List[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<Integer>();
        }
        for (int[] v : edges) {
            g[v[0]].add(v[1]);
            g[v[1]].add(v[0]);
        }
        dfs(0, -1, isRestricted, g);
        return cnt;
    }

    public void dfs(int x, int f, boolean[] isRestricted, List<Integer>[] g) {
        cnt++;
        for (int y : g[x]) {
            if (y != f && !isRestricted[y]) {
                dfs(y, x, isRestricted, g);
            }
        }
    }
}
