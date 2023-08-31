package easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class containsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set=new HashSet<Integer>();
        for (int num:nums) {
            if(set.contains(num)) return true;
            set.add(num);
        }
        return false;
    }
}
