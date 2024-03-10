package medium;

import java.util.HashMap;
import java.util.HashSet;

public class checkInclusion {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length()<s1.length()) return false;
        HashMap<Character,Integer> map = new HashMap<>();
        int left = 0,right = 0;
        int valid = 0;
        for (int i=0;i<s1.length();i++){
            char c = s1.charAt(i);
            map.put(c,map.getOrDefault(c,0)-1);
        }
        while (right<s2.length()){
            char rightChar=s2.charAt(right);
            right++;
            if (map.containsKey(rightChar)){
                int curVal = map.get(rightChar)+1;
                map.put(rightChar, curVal);
                if (curVal == 0) valid++;
            }
            while (valid == map.size()){
                if (right-left==s1.length()) return true;
                char leftChar = s2.charAt(left);
                left++;
                if (map.containsKey(leftChar)){
                    int curVal = map.get(leftChar)-1;
                    map.put(leftChar, curVal);
                    if (curVal!=0) valid--;
                }
            }
        }
        return false;
    }
}
