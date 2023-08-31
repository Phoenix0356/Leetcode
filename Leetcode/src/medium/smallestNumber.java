package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class smallestNumber {
    public long smallestNumber(long num) {
        ArrayList<Long> cnt= new ArrayList<Long>();
        int count=0;int size=0;
        long res=0;
        while(num!=(double)0){
            cnt.add(num%10);
            num/=10;
        }
        size=cnt.size();
        cnt.sort(Comparator.naturalOrder());
        if(num>=0){
            for(int i=0;i<cnt.size();i++) {
                if (cnt.get(0)!= 0) {
                    res +=(double) cnt.get(i)*(long) Math.pow(10, (double)size--);
                } else {
                    inner:for (int j=0;j<cnt.size();j++){
                        if (cnt.get(j)==0){
                            continue;
                        }else{
                            cnt.add(0,cnt.get(j));
                            cnt.remove(j+1);
                            break inner;
                        }
                    }
                    res +=(double) cnt.get(i)*(long) Math.pow(10, (double)size--);
                }
            }
        }else {
            for (int i=0;i<cnt.size();i++) {
                res +=(double) cnt.get(i)*(long) Math.pow(10, (double)size--);
            }
        }
        return res/10;
    }
}
