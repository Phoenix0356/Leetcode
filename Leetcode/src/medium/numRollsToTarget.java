package medium;

public class numRollsToTarget {
    public int numRollsToTarget(int n, int k, int target) {
        if (target < n || target > n * k) {
            return 0; // 无法组成 target
        }
        final int MOD = 1_000_000_007;
        int[][] f = new int[n + 1][target - n + 1];
        f[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= target - n; j++) {
                for (int x = 0; x < k && x <= j; x++) { // 掷出了 x
                    f[i][j] = (f[i][j] + f[i - 1][j - x]) % MOD;
                }
            }
        }
        return f[n][target - n];
    }
}
