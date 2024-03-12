package hard;

import java.util.*;

public class BlackList {

    int lastInd;
    int validSize;
    Map<Integer,Integer> map;

    Random random = new Random();
    public BlackList(int n, int[] blacklist) {
        validSize = n-blacklist.length;
        map = new HashMap<>();
        lastInd = n-1;

        for (int i:blacklist){
           map.put(i,1000);
        }
        for (int i:blacklist){
            if (i>validSize){
                continue;
            }
            while (map.containsKey(lastInd)){
                lastInd--;
            }
            map.put(i,lastInd);
        }


    }

    public int pick() {
        int num = random.nextInt(validSize);
        if (map.containsKey(num)){
            return map.get(num);
        }
        return num;
    }
}
