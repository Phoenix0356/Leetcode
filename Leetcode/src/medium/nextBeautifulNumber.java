package medium;

public class nextBeautifulNumber {
    public int nextBeautifulNumber(int n) {
        for (int i=n+1;i<=1224444;i++){
            if (isBalance(i)) return i;
        }
        return 0;
    }
    boolean isBalance(int n){
        int[] weights=new int[10];
        while (n>0){
            weights[n%10]++;
            n/=10;
        }
        for (int i=0;i<10;i++){
            if (weights[i]>0&&weights[i]!=i){
                return false;
            }
        }
        return true;
    }
}
