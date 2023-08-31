package medium;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class dailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack=new LinkedList<>();
        int[] ans=new int[temperatures.length];
        for (int i=0;i<temperatures.length;i++){
            int temperature=temperatures[i];
            while (!stack.isEmpty()&&temperature>temperatures[stack.peek()]){
                int pre=stack.pop();
                ans[pre]=i-pre;

            }
            stack.push(i);
        }
        return ans;
    }
}
