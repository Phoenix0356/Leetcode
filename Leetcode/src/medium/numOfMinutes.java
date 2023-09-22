package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class numOfMinutes {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        HashMap<Integer, ArrayList<Integer>> map=new HashMap<>();
        for (int i=0;i<manager.length;i++){
            if (manager[i]==-1) continue;
            if (!map.containsKey(manager[i])){
                ArrayList<Integer> l=new ArrayList<>();
                l.add(i);
                map.put(manager[i],l);
                continue;
            }
            map.get(manager[i]).add(i);
        }
        return find(map,informTime,headID,0);
    }
    int find(HashMap<Integer,ArrayList<Integer>> map,int[] informTime,int headId,int curTime){
        if (!map.containsKey(headId)) return curTime + informTime[headId];
        ArrayList<Integer> l=map.get(headId);
        int maxTime = 0;
        for (int n:l) {
            int time = find(map,informTime,n,curTime + informTime[headId]);
            maxTime = Math.max(maxTime, time);
        }
        return maxTime;
    }
}
