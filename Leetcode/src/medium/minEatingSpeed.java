package medium;

public class minEatingSpeed {
    public int minEatingSpeed(int[] piles, int h) {
            int l = 0, r = (int)1e9;
            while (l < r) {
                int mid = l + r >> 1;
                if (check(piles, mid, h)) r = mid;
                else l = mid + 1;
            }
            return r;
        }
        boolean check(int[] p, int k, int h) {
            int ans = 0;
            for (int x : p) ans += Math.ceil(x * 1.0 / k);
            return ans <= h;
    }
}
