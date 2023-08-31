package medium;

public class longestSubsequence {
    public int longestSubsequence(String s, int k) {
        int ans = 0;
        int sum = 0;

        for(int i = s.length() - 1; i >= 0; i--){
            if (s.charAt(i) != '0') {
                if (Math.pow(2, ans) + sum > k) continue;
                sum += Math.pow(2, ans);
            }
            ans += 1;
        }

        return ans;
    }
}
