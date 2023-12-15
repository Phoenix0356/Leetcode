package easy;

import java.util.Arrays;

public class makeSmallestPalindrome {
    public String makeSmallestPalindrome(String s) {
        char[] chars=new char[s.length()];
        for (int i=0;i<s.length();i++){
            char start=s.charAt(i);
            char end=s.charAt(s.length()-1-i);
            if (start!=end){
                if (start<end) end=start;
                else start=end;
            }
            chars[i]=start;
            chars[s.length()-1-i]=end;
        }
        StringBuilder sb=new StringBuilder();
        for (char c:chars) sb.append(c);
        return sb.toString();
    }
}
