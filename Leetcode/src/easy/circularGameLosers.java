package easy;

public class circularGameLosers {
    public int[] circularGameLosers(int n, int k) {
        boolean[] flag=new boolean[n];
        int ind=0,cnt=0;
        while (!flag[ind]){
            cnt++;
            flag[ind]=true;
            ind=(cnt*k+ind)%n;
        }

        int[] arr=new int[n-cnt];
        ind=0;
        for (int i=0;i<flag.length;i++){
            if (!flag[i]) arr[ind++]=i+1;
        }
        return arr;
    }
}
