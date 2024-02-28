package medium;

import java.util.Arrays;

public class smallestString {
    public String smallestString(String s) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        int start = 0;
        while (chars[start] == 'a') {
            sb.append('a');
            if (start == s.length()-1) {
                sb.delete(sb.length()-1,sb.length());
                sb.append('z');
                return sb.toString();
            }
            start++;
        }
        for (int i = start;i<s.length();i++) {
            if (chars[i] == 'a') flag = true;
            if (!flag) sb.append((char) (chars[i]-1));
            else sb.append(chars[i]);
        }
        return sb.toString();
    }

}
