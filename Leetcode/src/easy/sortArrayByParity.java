package easy;

public class sortArrayByParity {
    public int[] sortArrayByParity(int[] nums) {
       int start=0;
       int end=nums.length;
       int arr[]=new int[nums.length];
       for (int i:nums){
           if (i%2==0){
               arr[start++]=i;
           }else {
               arr[end--]=i;
           }
       }
       return arr;
    }
}
