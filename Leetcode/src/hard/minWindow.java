package hard;

import java.util.HashMap;
import java.util.Map;

public class minWindow {
    public String minWindow(String s, String t) {
        Map<Character,Integer> map = new HashMap<>();
        int left = 0;int right = 0;
        for (int i=0;i<t.length();i++){
            map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0)-1);
        }
        int minLen = Integer.MAX_VALUE;
        int valid = 0;
        String ans = "";
        while (right<s.length()){
            char rightChar = s.charAt(right);
            right++;
            if (map.containsKey(rightChar)){
                map.put(rightChar,map.get(rightChar)+1);
                if (map.get(rightChar)==0){
                    valid++;
                }
            }
            while(valid == map.size()){
                if (right-left<minLen){
                    minLen = right-left;
                    ans = s.substring(left,right);
                }
                char leftChar = s.charAt(left);
                left++;
                if (map.containsKey(leftChar)){
                    if (map.get(leftChar)<0) valid--;
                    map.put(leftChar,map.get(leftChar)-1);
                }
            }
        }
        return ans;
    }
}
