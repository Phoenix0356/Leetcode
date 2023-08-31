package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class insert {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] matrix=new int[intervals.length+1][2];
        int ind=0;
        for (int[] a:intervals){
            matrix[ind++]=a;
        }
        matrix[matrix.length-1][0]=newInterval[0];
        matrix[matrix.length-1][1]=newInterval[1];
        return merge(matrix);

    }
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0]==o2[0]) return o1[1]-o2[1];
                return o1[0]-o2[0];
            }
        });
        List<int[]> list=new ArrayList<>();
        int[] cur=new int[]{intervals[0][0],intervals[0][1]};
        for (int i=1;i<intervals.length;i++){
            System.out.println(cur[0]+" "+cur[1]);
            if (cur[1] < intervals[i][0]) {
                list.add(new int[]{cur[0],cur[1]});
                cur[0] = intervals[i][0];
            }
            if (cur[1]<intervals[i][1]) cur[1]=intervals[i][1];

        }
        list.add(cur);
        int[][] ans=new int[list.size()][2];

        for (int i=0;i< ans.length;i++)ans[i]=list.get(i);
        return ans;
    }
}
