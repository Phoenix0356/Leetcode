package hard;

public class nearestPalindromic {
    public String nearestPalindromic(String n) {
            char[] c = n.toCharArray();
            int end = n.length() - 1, count = 0;
            if (n.equals("10") || n.equals("11")) return "9";
            if (n.length() == 1) return Integer.toString(Integer.valueOf(n) - 1);
            if (n.length() == 2) {
                if (c[0] > c[1] || Character.compare(c[0], c[1]) == 0) {
                    c[0]--;
                    c[1] = c[0];
                } else {
                    c[1] = c[0];
                }
            } else if (n.length() != 2) {
                for (int i = 0; i < n.length() / 2; i++) {
                    if (c[i] == c[end]) count++;
                    c[end--] = c[i];
                }
                if (count == n.length() / 2) {
                    if ((n.length() - 1) % 2 == 0) {
                        c[n.length() / 2]--;
                        c[n.length() / 2 + 1]--;
                    } else c[n.length() / 2]--;
                }
            }
            String ans = Character.toString(c[0]);
            for (int i = 1; i < c.length; i++) {
                ans += c[i];
            }
            if (Character.toString(n.charAt(0)).equals("1") && n.length() == 2) ans = "11";
            return ans;
    }
}
