package easy;

import java.util.HashMap;
import java.util.Map;

public class firstUniqChar {
    public int firstUniqChar(String s) {
        Map<Character,Integer> map=new HashMap<>();
        char ans='.';
        int ind=0;
        for (char c:s.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }
        for (char c:s.toCharArray()){
            if (map.get(c)==1){
                ans=c;
                break;
            }
        }
        return ind=ans=='.'?-1:s.indexOf(ans);
    }
}
