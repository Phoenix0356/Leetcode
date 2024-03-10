package medium;

public class searchRange {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[]{-1,-1};
        ans[0] = biSearch(nums,target,true);
        ans[1] = biSearch(nums,target,false);
        return ans;

    }
    public int biSearch(int[] nums , int target, boolean isLeftLimit){
        int left = 0; int right = nums.length;
        boolean isFind = false;
        while (left < right){
            int mid = left + (right - left)/2;
            if (nums[mid] == target){
                isFind = true;
                if (isLeftLimit) right = mid;
                else left = mid+1;
            }else if (nums[mid] > target){
                right = mid;
            }else {
                left = mid+1;
            }
        }
        if (!isFind) return -1;
        return isLeftLimit?left:left-1;
    }
}
