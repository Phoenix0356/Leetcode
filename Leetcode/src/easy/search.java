package easy;

public class search {
    public int search(int[] nums, int target) {
        int low=0,high=nums.length-1;
        for (int i=0;i<nums.length;i++) {
            int middle=(low+high)/2;
            if (nums[middle] > target) {
                high=middle-1;
            } else if (nums[middle] < target) {
                low = middle+1;
            } else if (nums[middle]==target) return middle;
        }

        return -1;
    }
}
