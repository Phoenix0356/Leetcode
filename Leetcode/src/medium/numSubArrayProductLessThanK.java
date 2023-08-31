package medium;

public class numSubArrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int res=0,count=1,ind=0;;
        for (int i=0;i<nums.length;i++){
            count*=nums[i];
            if (count<k&&i+1==nums.length){
                res++;
                i=++ind;
                continue;
            }
            if (count<k){
                res++;
            }else {
                i=++ind;
                count=1;
            }
        }
        return res;
    }
}
