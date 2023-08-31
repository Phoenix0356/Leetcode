package easy;

public class isUgly {
    public boolean isUgly(int n) {
        if (n==0) return false;
        return isMod(n);
    }
    boolean isMod(int n){
        if (n==1)return true;
        if (n%2==0) return isMod(n/2);
        else if (n%3==0) return isMod(n/3);
        else if (n%5==0) return isMod(n/5);

        return false;
    }
}
