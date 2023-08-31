package medium;

class Bitset {
    int dp[], size, cnt = 0, f = 0;

    public Bitset(int size) {
        this.size = size;
        dp = new int[size];
    }

    public void fix(int idx) {
        if ((dp[idx] + f) % 2 == 0) {
            cnt++;
            dp[idx]++;
        }
    }

    public void unfix(int idx) {
        if ((dp[idx] + f) % 2 == 1) {
            cnt--;
            dp[idx]++;
        }
    }

    public void flip() {
        cnt = size - cnt;
        f++;
    }

    public boolean all() {
        return cnt == size;
    }

    public boolean one() {
        return cnt > 0;
    }

    public int count() {
        return cnt;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) sb.append((dp[i] + f) % 2);
        return sb.toString();
    }
}

