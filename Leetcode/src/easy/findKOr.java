package easy;

public class findKOr {
    public int findKOr(int[] nums, int k) {
        int[] count = new int[32];
        int ans = 0;
        for (int num : nums) {
            findOneWeight(count,num);
        }
        for (int i = 0; i < count.length; i++) {
            System.out.println(count[i]);
            if (count[i] >= k){
                ans+= (int) Math.pow(2,i);
            }
        }
        return ans;
    }

    private void findOneWeight(int[] count, int num){
        int ind = 0;
        while (num>0){
            if (num%2!=0){
                count[ind]++;
            }
            ind++;
            num=num>>1;
        }
    }
}
