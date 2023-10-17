package easy;

public class sumOfMultiples {
    public int sumOfMultiples(int n) {
        int ans=0;
        for (int i=0;i<=n;i++){
            if (i%7==0) ans+=i;
            else if (i%5==0) ans+=i;
            else if (i%3==0) ans+=i;
        }
        return ans;
    }
}
