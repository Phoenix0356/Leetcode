package easy;

import java.util.ArrayList;

public class RecentCounter {
    ArrayList<Integer> l;
    public RecentCounter() {
    }

    public int ping(int t) {
        l.add(t);
        while (l.get(0)+3000<t) l.remove(0);
        return l.size();
    }
}
