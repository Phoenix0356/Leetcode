package easy;

import java.util.Arrays;

public class climbStairs {
    public int climbStairs(int n) {
        return numsOfStep(n)+1;
    }
    int numsOfStep(int n){
        while (n>1) {
            n *= numsOfStep(n - 1);
        }
        return n+1;
    }
}
