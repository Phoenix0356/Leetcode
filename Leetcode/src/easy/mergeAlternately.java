package easy;

public class mergeAlternately {
    public String mergeAlternately(String word1, String word2) {
        String[] s1 = word1.split("");
        String[] s2 = word2.split("");
        int l = Math.min(s1.length, s2.length), ind = 0;
        StringBuilder sb = new StringBuilder();
        for (; ind < l; ind++) {
            sb.append(s1[ind]);
            sb.append(s2[ind]);
        }
        if (s1.length > s2.length) {
            for (int i = ind; i < s1.length; i++) {
                sb.append(s1[i]);
            }
        } else {
            for (int i = ind; i < s2.length; i++) {
                sb.append(s2[i]);
            }
        }
        return sb.toString();
    }
}
