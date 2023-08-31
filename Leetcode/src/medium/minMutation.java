package medium;

import java.util.*;

public class minMutation {
    char[] c={'A','T','C','G'};
    public int minMutation(String S, String T, String[] bank) {
        Set<String> set=new HashSet<>();
        for (String s:bank)set.add(s);
        Map<String,Integer> map=new HashMap<>();
        map.put(S,0);
        Deque<String> d=new ArrayDeque<>();
        d.add(S);
        while (!d.isEmpty()){
            int size=d.size();
            while (size-->0){
                String s=d.pollFirst();
                int step=map.get(s);
                char[] ch=s.toCharArray();
            for (int i=0;i<8;i++){
                for (char c:c){
                    if (c==ch[i])continue;
                    char[] clone=ch.clone();
                    clone[i]=c;
                    String sub=String.valueOf(clone);
                    if (!set.contains(sub)) continue;
                    if (map.containsKey(sub)) continue;
                    if (sub.equals(T)) return step + 1;
                    map.put(sub,step+1);
                    d.addLast(sub);
                    }
                }
            }
        }
        return -1;
    }
}
