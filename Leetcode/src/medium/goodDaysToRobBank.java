package medium;

import java.util.ArrayList;
import java.util.List;

public class goodDaysToRobBank {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        int start=time,end=security.length-time,pre=0;
        List<Integer> list=new ArrayList<>();
        if (time==0){
            for (int i=0;i<security.length;i++){
                list.add(i);
            }
            return list;
        }
        list.add(-2);
        for (int i=start;i<end;i++) {
            int change = 0, isDay = 0, count = 0;
            pre=i-1;
            inner:
            while (count++ < time) {
                if (list.get(list.size()-1)==pre) {
                    if (security[i - 1] >= security[i] && security[i + time - 1] <= security[i + time]) {
                        list.add(i);
                        break inner;
                    }
                } else {
                    if (security[i - change] > security[i - change - 1]) break inner;
                    if (security[i + change] > security[i + change + 1]) break inner;
                    change++;
                    isDay++;
                }
                if (isDay == time) list.add(i);
            }
        }
        list.remove(0);
        return list;
    }
}

