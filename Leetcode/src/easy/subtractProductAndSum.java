package easy;

public class subtractProductAndSum {
    public int subtractProductAndSum(int n) {
        int prod=1,sum=0;
        while (n>0){
            int temp=n%10;
            n/=10;
            prod*=temp;
            sum+=temp;

        }
        return prod-sum;
    }
}
