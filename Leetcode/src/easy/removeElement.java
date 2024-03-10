package easy;

public class removeElement {
    public int removeElement(int[] nums, int val) {
        int slow = 0,fast = 0;
        while (fast<nums.length) {
            if (nums[fast] == val){
                fast++;
            }else {
                nums[slow++] = nums[fast++];

            }
        }
        return slow;
    }
}
