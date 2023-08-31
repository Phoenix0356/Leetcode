package easy;

public class alternateDigitSum {
    public int alternateDigitSum(int n) {
        int tempP=0,tempN=0,cnt=0,co=1,mod;
        while (n>0){
            mod=n%10;
            n/=10;
            tempN+=-1*co*mod;
            tempP+=co*mod;
            co=-co;
            cnt++;
        }
        return cnt%2==0?tempN:tempP;
    }
}
