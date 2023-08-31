package easy;

import java.util.ArrayList;
import java.util.List;

public class selfDividingNumbers {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list=new ArrayList<>();
        while (left<=right){
            int temp=left;
            while (temp>0){
                int denominator=temp%10;
                if (denominator==0)break;
                if (left%denominator!=0) break;
                temp/=10;
                if (temp==0)list.add(left);
            }
            left++;
        }
        return list;
    }
}
