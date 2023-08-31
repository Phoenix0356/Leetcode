package medium;

import java.util.HashMap;

public class equalPairs {
    public static int equalPairs(int[][] grid) {
        int n= grid.length,count=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int[] ints : grid) {
            StringBuilder rowTemp=new StringBuilder();
            for (int num : ints) rowTemp.append(num).append(",");
            int rowHash = rowTemp.toString().hashCode();
            map.put(rowHash, map.getOrDefault(rowHash, 0) + 1);
        }
        for (int j=0;j<n;j++){
            StringBuilder colTemp=new StringBuilder();
            for (int[] ints : grid) colTemp.append(ints[j]).append(",");
            int colHash=colTemp.toString().hashCode();
            if (map.containsKey(colHash)) {
                count+= map.get(colHash);
            }
        }
        return count;
    }
}
