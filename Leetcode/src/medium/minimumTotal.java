package medium;

import java.util.List;

public class minimumTotal {
    public int minimumTotal(List<List<Integer>> triangle) {
        for (int i=1;i< triangle.size();i++){
            for (int j=0;j<triangle.get(i).size();j++){
                int pre,cur=triangle.get(i).get(j);
                if (j-1>=0&&j<triangle.get(i-1).size()){
                    pre=Math.min(triangle.get(i-1).get(j-1),triangle.get(i-1).get(j));
                }else if (j==triangle.get(i-1).size()) pre=triangle.get(i-1).get(j-1);
                else pre=triangle.get(i-1).get(j);
                triangle.get(i).set(j,cur+pre);
            }
        }
        int min=Integer.MAX_VALUE;
        for (int num:triangle.get(triangle.size()-1)){
            if (min>num) min=num;
        }
        return min;
    }
}
