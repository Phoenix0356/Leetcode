package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class luckyNumbers {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int ans=0,idx=0,cnt=0;
        ArrayList<Integer> res=new ArrayList<>();
        for (int i=0;i<matrix.length;i++) {
            int min=matrix[i][0];
            for (int j=1;j<matrix[0].length;j++){
                if (matrix[i][j]<min) {
                    min = matrix[i][j];
                    idx=j;
                }
            }
            res.add(min);
            cnt++;
            for (int z=0;z<matrix.length;z++){
                if (matrix[z][idx]>min){
                    res.remove(cnt-1);
                    cnt--;
                    break;
                }
            }
        }
        return res;
    }
}
