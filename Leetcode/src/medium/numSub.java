package medium;

public class numSub {
    public int numSub(String s) {
        int cnt=0;
        long sum=0;
        double m=1e9+7;
        for (int i=0;i<s.length();i++){
            if (s.charAt(i)=='1') cnt++;
            else {
                sum+=count(cnt);
                cnt=0;
            }
        }
        sum+=count(cnt);

        return (int) (sum%m);
    }
    long count(int l){
        long sum=0;
        while (l>0){
            sum+=l;
            l--;
        }
        return sum;
    }
}
