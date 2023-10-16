package easy;

import com.sun.jdi.Value;

import java.util.HashMap;
import java.util.HashSet;

public class singleNumber {
    public int singleNumber(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int n:nums) map.put(n,map.getOrDefault(n,0)+1);
        for (Integer key: map.keySet()){
            if (map.get(key)==1) return key;
        }
        return 0;
    }
}
