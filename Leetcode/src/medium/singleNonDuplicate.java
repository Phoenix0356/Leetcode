package medium;

public class singleNonDuplicate {

    public int singleNonDuplicate(int[] nums) {
        if (nums.length==1)return nums[0];
        int ans=-1;
        for (int i=1;i<nums.length;i=i+2){
            if (nums[i]+nums[i-1]!=2*nums[i]){
                ans=nums[i-1];
                break;
            }
        }
        if (ans==-1)ans=nums[nums.length-1];
        return ans;
    }
    public int singleNonDuplicate2(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (nums[mid] == nums[mid ^ 1]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return nums[low];
    }


}
