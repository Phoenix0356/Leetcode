package medium;

public class numberOfSubstrings {
        public int numberOfSubstrings(String s) {
            int res = 0;
            int[] record = {-1, -1, -1};
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == 'a') {
                    res += Math.min(record[1], record[2]) + 1;
                } else if (s.charAt(i) == 'b') {
                    res += Math.min(record[0], record[2]) + 1;
                } else {
                    res += Math.min(record[0], record[1]) + 1;
                }
                record[s.charAt(i) - 'a'] = i;
            }
            return res;
        }
}
