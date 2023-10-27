package easy;

public class countDigits {
    public int countDigits(int num) {
        int cnt=0,temp=num;
        while (temp>0){
            int mod=temp%10;
            temp/=10;
            if (num%mod==0) cnt++;
        }
        return cnt;
    }
}
