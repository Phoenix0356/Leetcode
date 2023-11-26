package hard;

public class maximumRequests {
    int[] status;
    int zeros,n,cnt=0,ans=0;
    public int maximumRequests(int n, int[][] requests) {
        status = new int[n];
        zeros=n;
        this.n=n;
        dfs(requests,0);
        return ans;


    }
    void dfs(int[][] requests,int ind){
        if (ind==requests.length){
            if (zeros==n){
                ans=Math.max(cnt,ans);
            }
            return;
        }
        dfs(requests,ind+1);
        int z = zeros;
        ++cnt;
        int x=requests[ind][0],y=requests[ind][1];

        zeros-=status[x]==0?1:0;
        --status[x];
        zeros+=status[x]==0?1:0;

        zeros-=status[y]==0?1:0;
        ++status[y];
        zeros+=status[y]==0?1:0;

        dfs(requests,ind+1);

        ++status[x];
        --status[y];
        --cnt;
        zeros=z;

    }
}
