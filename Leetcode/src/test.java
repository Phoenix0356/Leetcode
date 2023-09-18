import WeeklyGames.g10;

import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
        g10 g=new g10();
        int[] arr=new int[]{1,1,2,2,4,4};
        List<Integer> l=new ArrayList<>();
        for (int i:arr) l.add(i);
        g.minLengthAfterRemovals(l);
    }
}
