package easy;

import java.util.HashSet;
import java.util.Set;

public class uniqueMorseRepresentations {
    String[] ss = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
    public int uniqueMorseRepresentations(String[] words) {
        Set<String> set = new HashSet<>();
        for (String s : words) {
            StringBuilder sb = new StringBuilder();
            for (char c : s.toCharArray()) sb.append(ss[c - 'a']);
            set.add(sb.toString());
        }
        return set.size();
    }
}
