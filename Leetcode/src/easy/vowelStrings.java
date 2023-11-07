package easy;

import java.util.HashSet;

public class vowelStrings {

    public int vowelStrings(String[] words, int left, int right) {
        HashSet<Integer> dict=new HashSet<>();
        dict.add(0);
        dict.add('e'-'a');
        dict.add('i'-'a');
        dict.add('o'-'a');
        dict.add('u'-'a');
        int cnt=0;
        for (int i=left;i<=right;i++){
            if (dict.contains(words[i].charAt(0)-'a')&&dict.contains(words[i].charAt(words[i].length()-1)-'a')){
                cnt++;
            }
        }
        return cnt;
    }
}
