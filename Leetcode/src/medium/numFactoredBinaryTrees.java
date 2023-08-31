package medium;

import java.util.*;

public class numFactoredBinaryTrees {
    public int numFactoredBinaryTrees(int[] arr) {
        int cnt=0;
        long mod=(long) 1e9+7;
        HashMap<Integer,Integer> map=new HashMap<>();
        Arrays.sort(arr);
        long[] memo=new long[arr.length];
        Arrays.fill(memo,-1);
        for (int i =0;i<arr.length;i++) map.put(arr[i],i);
        for (int i=arr.length-1;i>=0;i--){
            cnt+=dfs(arr[i],arr,map,memo);
        }
        return (int)(cnt%mod);
    }

    long dfs(int ind, int[] arr, HashMap<Integer,Integer> map,long[] memo) {
        if (memo[ind]!=-1) return memo[ind];
        long res = 1;
        for (int i=0;i<ind;i++){
            int fact=arr[ind]/arr[i];
            if (arr[ind]%arr[i]==0&&map.containsKey(fact)){
                res+=dfs(map.get(fact),arr,map,memo)*dfs(map.get(arr[i]),arr,map,memo);
            }
        }
        return memo[ind]=res;
    }

}
