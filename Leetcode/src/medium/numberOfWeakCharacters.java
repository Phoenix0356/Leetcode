package medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class numberOfWeakCharacters {
    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, new Comparator<int[]>() {
                    @Override
                    public int compare(int[] o1, int[] o2) {
                        if (o1[0]==o2[0])return o1[1]-o2[1];
                        return o1[0]-o2[0];
                    }
                }
        );
        int idx=0,count=0;
        Stack<int[]> stack=new Stack<>();
        stack.add(new int[]{-1,Integer.MAX_VALUE,Integer.MAX_VALUE});
        for (int i=0;i< properties.length;i++){
            while (stack.peek()[1]<properties[i][1]&&stack.peek()[0]<properties[i][0]){
                stack.pop();
                count++;
            }
            stack.add(new int[]{idx++,properties[i][1],properties[i][1]});
        }
        return count;
    }
}
