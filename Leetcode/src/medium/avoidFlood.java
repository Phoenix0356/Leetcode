package medium;

import java.util.*;

public class avoidFlood {
    public int[] avoidFlood(int[] rains) {
        int[] a = new int[rains.length];
        Arrays.fill(a, 1);
        TreeSet<Integer> st = new TreeSet<Integer>();
        Map<Integer, Integer> mp = new HashMap<Integer, Integer>();
        for (int i = 0; i < rains.length; ++i) {
            if (rains[i] == 0) {
                st.add(i);
            } else {
                a[i] = -1;
                if (mp.containsKey(rains[i])) {
                    Integer it = st.ceiling(mp.get(rains[i]));
                    if (it == null) {
                        return new int[0];
                    }
                    a[it] = rains[i];
                    st.remove(it);
                }
                mp.put(rains[i], i);
            }
        }
        return a;
    }
}
