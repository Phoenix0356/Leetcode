package easy;

import java.util.HashMap;
import java.util.Map;

public class canConstruct {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character,Integer> map=new HashMap<>();
        for (int i=0;i<magazine.length();i++){
            map.put(magazine.charAt(i), map.getOrDefault(magazine.charAt(i),0)+1);
            map.put(ransomNote.charAt(i),map.getOrDefault(ransomNote.charAt(i),-1)-1);
        }
        return true;
    }
}
