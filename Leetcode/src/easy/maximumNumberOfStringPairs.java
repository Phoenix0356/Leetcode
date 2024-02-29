package easy;

import java.util.HashSet;

public class maximumNumberOfStringPairs {
    public int maximumNumberOfStringPairs(String[] words) {
        HashSet<String> set = new HashSet<>();
        int sameNumber = 0;
        int ans = 0;
        for (String word : words) {
            if (isAllSame(word)){
                sameNumber++;
            }
            StringBuilder stringBuilder = new StringBuilder(word);
            set.add(stringBuilder.reverse().toString());
        }
        for (String word : words) {
            if (set.contains(word)) ans++;
        }
        return (ans-sameNumber)/2;
    }
    private boolean isAllSame(String word){
        for (int i=0;i<word.length()-1;i++){
            if (word.charAt(i)!=word.charAt(i+1)) return false;
        }
        return true;
    }
}
