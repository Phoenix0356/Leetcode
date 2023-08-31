package easy;

public class sumOfUnique {
    public int sumOfUnique(int[] nums) {

            int res=0;
            int ans=0;
            boolean[] sign=new boolean[100];
            for(int i=0;i<nums.length;i++){
                res+=nums[i];
                int count=1;
                for(int j=i+1;j<nums.length;j++){
                    if(nums[i]==nums[j]&&sign[nums[i]-1]==false){
                        count++;
                    }
                }
                sign[nums[i]-1]=true;
                if(count!=1){
                    res=res-nums[i]*count;
                }
            }
            return res;
    }
}