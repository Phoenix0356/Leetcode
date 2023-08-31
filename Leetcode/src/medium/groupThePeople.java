package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class groupThePeople {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        boolean[][] flag=new boolean[501][501];
        List<List<Integer>> list=new ArrayList<>();
        for (int i=0;i< groupSizes.length;i++) {
            flag[groupSizes[i]][i]=true;
            flag[groupSizes[i]][0]=true;

        }
        list.add(new ArrayList<>());
        for (int i=1;i< flag.length;i++){
            if (!flag[i][0]) continue;
            int count=0;
            for (int j=0;j<flag[0].length;j++){
                if (!flag[i][j])continue;
                list.get(list.size()-1).add(j);
                if (++count%i==0){
                    list.add(new ArrayList<>());
                }
            }
        }
        list.remove(list.size()-1);
        return list;
    }
}
