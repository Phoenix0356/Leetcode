package medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class largestValsFromLabels {
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        int l = values.length;
        int[][] arr = new int[l][2];
        int ans = 0;
        Map<Integer,Integer> map =new HashMap<>();
        for (int i=0;i<l;i++){
            arr[i][0] = labels[i];
            arr[i][1] = values[i];
            map.put(labels[i],0);
        }
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) return o2[0]-o1[0];
                return o2[1]-o1[1];
            }
        });
        for (int i=0;i<l;i++){
            if (map.get(arr[i][0])<useLimit){
                ans+=arr[i][1];
                numWanted--;
                map.put(arr[i][0],map.get(arr[i][0])+1);
            }
            if (numWanted == 0){
                return ans;
            }
        }
        return ans;
    }
}
