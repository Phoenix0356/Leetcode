package medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class matrixSumQueries {
    public long matrixSumQueries(int n, int[][] queries) {
        HashSet<Integer>[] set=new HashSet[]{new HashSet<>(),new HashSet<>()};
        long cnt=0;
        for (int i=queries.length-1;i>=0;i--){
            if (!set[queries[i][0]].contains(queries[i][1])){
                cnt+=(long)queries[i][2]*(n-set[queries[i][0]^1].size());
                set[queries[i][0]].add(queries[i][1]);
            }
        }
        return cnt;
    }


}
