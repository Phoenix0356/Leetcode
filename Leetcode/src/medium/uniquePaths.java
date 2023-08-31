package medium;

public class uniquePaths {
    public int uniquePaths(int m, int n) {
        //只跟第几行第几列有关，从m+n-2步中抽出m-1步
        long ans=1;
        for(int i=0;i<Math.min(m-1,n-1);i++){
            ans*=m+n-2-i;
            ans/=i+1;
        }
        return (int)ans;
    }
}
