package medium;

import java.util.*;
import java.util.stream.Collectors;

public class watchedVideosByFriends {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        HashMap<String,Integer> map=new HashMap<>();
        boolean[] visited=new boolean[friends.length];
        Queue<int[]> q=new LinkedList<>();
        q.offer(new int[]{id,0});
        visited[id]=true;
        while (q.size()>0){
            int[] cur=q.poll();
            if (cur[1]<level){
                for (int i:friends[cur[0]]){
                    if (visited[i]) continue;
                    visited[i]=true;
                    q.offer(new int[]{i,cur[1]+1});
                }
            }else {
                for (String s:watchedVideos.get(cur[0])){
                    map.put(s, map.getOrDefault(s,0)+1);
                }
            }
        }
        List<String> res = new ArrayList<>();
        for (String key : map.keySet()) {
            res.add(key);
        }
        res = res.stream().sorted((x, y)->{
            if (Objects.equals(map.get(x), map.get(y))) {
                return x.compareTo(y);
            } else {
                return map.get(x) - map.get(y);
            }
        }).collect(Collectors.toList());

        return res;
    }


}
