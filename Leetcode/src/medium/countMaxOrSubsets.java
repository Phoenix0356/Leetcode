package medium;

public class countMaxOrSubsets {
    public int countMaxOrSubsets(int[] nums) {
        int n=nums.length,mask=1<<n;
        int max=0,ans=0;
        for (int i=0;i<mask;i++){
            int cur=0;
            for (int j=0;j<n;j++){
                if ((i>>j&1)==1)cur|=nums[j];
            }
            if (max<cur){
                max=cur;cur=1;
            }else if (max==cur){
                ans++;
            }
        }
        return ans;
    }
}
