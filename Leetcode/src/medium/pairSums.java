package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class pairSums {
    public List<List<Integer>> pairSums(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();
        for (int n:nums) {
            if(map.containsKey(target-n) && map.get(target-n) >= 1){
                map.put(target-n,map.get(target-n)-1);
                List<Integer> list = new ArrayList<>();
                list.add(target-n);
                list.add(n);
                res.add(list);
            }else {
                map.put(n,map.getOrDefault(n,0)+1);
            }
        }
        return res;
    }
}
