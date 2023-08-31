package easy;

public class minimumMoves {
    public int minimumMoves(String s) {
        int ans = 0;

        for(int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'X') {
                i += 2;
                ans++;
            }
        }

        return ans;
    }
}
