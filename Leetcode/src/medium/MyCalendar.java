package medium;

import java.util.ArrayList;
import java.util.List;

public class MyCalendar {
    List<int[]> list;
    public MyCalendar() {
        list=new ArrayList<>();
    }

    public boolean book(int start, int end) {
        for (int[] a:list) if ((a[0]<=start&&a[1]>start)||
                (a[0]<end&&a[1]>start)||
                (a[0]>=start&&a[1]<=end)) return false;
        list.add(new int[]{start,end});
        return true;
    }
}
