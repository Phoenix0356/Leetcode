package easy;

import java.util.HashSet;

public class isHappy {
    HashSet<Integer> set=new HashSet<>();
    public boolean isHappy(int n) {
        return recurse(count(n));
    }
    boolean recurse(int n){
        if (n==1) return true;
        if (set.add(n)) return recurse(count(n));
        return false;
    }
    int count(int n){
        int res=0;
        while (n>0){
            res+=(n%10)*(n%10);
            n/=10;
        }
        return res;
    }
}
