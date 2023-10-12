package easy;

public class findTheArrayConcVal {
    public long findTheArrayConcVal(int[] nums) {
        int l= nums.length;
        long ans=l%2==0?0:nums[l/2];
        for (int i=0;i<nums.length/2;i++) {
            String s=String.valueOf(nums[i])+ nums[l - 1 - i];
            ans+=Integer.parseInt(s);
        }
        return ans;
    }
}
