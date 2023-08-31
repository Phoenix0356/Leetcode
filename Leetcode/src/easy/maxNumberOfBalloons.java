package easy;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class maxNumberOfBalloons {
    public int maxNumberOfBalloons(String text) {
        Map<Character ,Integer> map = new HashMap<Character,Integer>();

        char[] ss = text.toCharArray();

        for (int i = 0 ; i< ss.length;i++){
            map.put(ss[i],map.getOrDefault(ss[i],0)+1);
        }

        int res = 0;
        int b = map.getOrDefault('b',0);
        int a = map.getOrDefault('a',0);
        int l = map.getOrDefault('l',0);
        int o = map.getOrDefault('o',0);
        int n = map.getOrDefault('n',0);

        int count1 = Math.min(Math.min(b,a),n);
        int count2 = Math.min(l/2,o/2);
        return Math.min(count1,count2);
    }
}
