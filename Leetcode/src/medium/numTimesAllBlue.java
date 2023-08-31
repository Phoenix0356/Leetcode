package medium;

public class numTimesAllBlue {

    public int numTimesAllBlue(int[] flips) {
        int l= flips.length;
        int ans=0,ind=1,cur=0;
        for (int n:flips) {
            cur=Math.max(cur,n);
            if (cur==ind++) ans++;
        }
        return ans;
    }
}
