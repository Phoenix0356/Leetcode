package WeeklyGames;

public class g2 {
    public int findMaxK(int[] nums) {
        int max=-1;
        for(int i=0;i< nums.length;i++){
            for(int j=0;j< nums.length;j++){
                if (nums[i]==-nums[j]&&i!=j){
                    max=Math.max(Math.abs(nums[i]), max);
                }
            }
        }
       return max;
    }
    public int countDistinctIntegers(int[] nums) {
        int[] nums2=new int[nums.length];
        boolean[] flag=new boolean[2*nums.length];
        int cnt=2*nums.length,temp;
        int[] arr=new int[2* nums.length];
        for (int i=0;i< nums.length;i++){
            temp=nums[i];
            while (temp>0){
                nums2[i]=nums2[i]*10+temp%10;
                temp=temp/10;
            }
            arr[i]= nums[i];
            arr[nums.length+i]=nums2[i];
            for (int j=0;j<arr.length;j++){
                if (arr[nums.length+i] == arr[j] &&!flag[j]) {
                    flag[j] = true;
                    cnt--;
                }
            }
        }
        return cnt;
    }
}
