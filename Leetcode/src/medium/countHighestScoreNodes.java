package medium;

import java.util.Arrays;

public class countHighestScoreNodes {
    public int countHighestScoreNodes(int[] parents) {
        if (parents.length==2)return 2;
        if (parents.length==3)return 2;
        int n=parents.length,save=0,ans=1;
        boolean[] flag=new boolean[n];
        int[] arr=new int[n/2*(n/2+1)];
        for (int i=0;i<n;i++){
            flag[0]=true;
            save=parents[i];
            parents[i]=-1;
            arr[dfs(i, parents, flag,ans)]++;
            Arrays.fill(flag, false);
            parents[i]=save;
            ans=1;
        }
        arr[0]=0;
        Arrays.sort(arr);
        return arr[arr.length-1];
    }
    int dfs(int i,int[] arr,boolean[] flag,int ans){
        int count=0;
        if (arr[i]!=-1){
            if (flag[i]==false) {
                count++;
                flag[i] = true;
                dfs(arr[i], arr, flag,count);
            }else {
                for (int j=0;i<flag.length;j++){
                    if (flag[j]==false){
                        dfs(j,arr,flag,count);
                    }
                }
            }
        }else {
            ans*=count;
            count=0;
            for (int j=0;i<flag.length;j++){
                if (flag[j]==false){
                    dfs(j,arr,flag,count);
                }
            }
        }
        return ans=ans==1?0:ans;
    }
}
