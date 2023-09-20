package easy;

public class averageValue {
    public int averageValue(int[] nums) {
        int sum=0,num=0;
        for (int n:nums){
            if (n%3==0&&n%2==0) {
                sum+=n;
                num++;
            }
        }
        return num==0?0:sum/num;
    }
}
