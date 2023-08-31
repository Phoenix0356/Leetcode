package easy;

public class arithmeticTriplets {
    public int arithmeticTriplets(int[] nums, int diff) {
        int ans=0;
        for (int i=0;i< nums.length;i++){
            int count=0,ind=i;
            for (int j=i;j<nums.length;j++){
                if (nums[ind]==nums[j]-diff) {
                    count++;
                    ind=j;
                }
                if (count==3) {
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }
}
