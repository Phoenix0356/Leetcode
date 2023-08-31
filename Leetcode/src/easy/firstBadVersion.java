package easy;

public class firstBadVersion {
    public int firstBadVersion(int n) {
        int low=1,high=n;
        while (low<high){
            int m=low+(high-low)/2;
            if (!isBadVersion(m,n)){
                low=m+1;
            }else {
                high=m;
            }
        }
        return low;
    }

    boolean isBadVersion(int version,int n){
        return version==n?true:false;
    }
}
