package medium;

import java.util.ArrayList;
import java.util.HashMap;

public class tupleSameProduct {
    public int tupleSameProduct(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int ans=0;
        for(int i=0;i< nums.length;i++){
            for (int j=i+1;j< nums.length;j++){
                int product=nums[i]*nums[j];
                map.put(product,map.getOrDefault(product,0)+1);
            }
        }
        for (int v:map.values())ans+=sum(v);
        return ans;
    }
    int sum(int n){
        int sum=0;
        for (int i=n-1;i>0;i--) sum+=i;
        return 8*sum;
    }
}
