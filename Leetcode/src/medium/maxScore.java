package medium;

public class maxScore {
    public int maxScore(int[] cardPoints, int k) {
        int max=0,end=cardPoints.length-1;
        for (int i=0;i<k;i++){
            max+=cardPoints[i];
        }
        int ans=max;
        for (int i=k-1;i>=0;i--){
            max-=cardPoints[i];
            max+=cardPoints[end--];
            ans=Math.max(ans,max);

        }
        return ans;
    }
}
