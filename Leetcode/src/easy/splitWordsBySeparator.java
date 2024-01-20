package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class splitWordsBySeparator {
    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> l=new ArrayList<>();

        for (String word : words) {
            int start = 0;
            int len = word.length();
            for (int i=0;i<len;i++){
                if (word.charAt(i)==separator){
                    if(start != i){
                        l.add(word.substring(start,i));

                    }
                    start = i+1;
                }

            }
            if(start<len){
                l.add(word.substring(start,len));
            }

        }
        return l;
    }

}
