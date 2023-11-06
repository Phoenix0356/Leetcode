package easy;

import java.util.HashSet;

public class countPoints {
    public int countPoints(String rings) {
        int cnt=0;
        HashSet<Character>[] sets=new HashSet[10];
        for (int i = 0; i < 10; i++) {
            sets[i] = new HashSet<>();
        }
        for (int i=0;i<rings.length()-1;i+=2){
            char color=rings.charAt(i);
            int ind=rings.charAt(i+1)-'0';

            sets[ind].add(color);
        }
        for (HashSet set:sets){
            if (set.size()==3) cnt++;
        }
        return cnt;
    }
}
