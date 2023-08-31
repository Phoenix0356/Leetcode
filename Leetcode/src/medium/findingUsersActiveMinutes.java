package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class findingUsersActiveMinutes {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        int[] ans=new int[k];

        HashMap<Integer,HashSet<Integer>> usersMap=new HashMap<>();
        for (int[] log : logs) {
            int id = log[0], uam = log[1];
            if (!usersMap.containsKey(id)){
                HashSet<Integer> set=new HashSet<>();
                set.add(uam);
                usersMap.put(id,set);
            }else {
                usersMap.get(id).add(uam);
            }
        }
        for (Integer integer:usersMap.keySet()) ans[usersMap.get(integer).size()-1]++;
        return ans;
    }
}
