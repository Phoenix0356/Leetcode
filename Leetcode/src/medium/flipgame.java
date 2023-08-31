package medium;

public class flipgame {
    public int flipgame(int[] fronts, int[] backs) {
        int ans=1001;
        boolean[] set=new boolean[2001];
        for (int i=0;i<fronts.length;i++){
            if (fronts[i]==backs[i]) set[fronts[i]]=true;
        }
        for (int i=0;i<fronts.length;i++){
            if (set[fronts[i]]) ans=Math.min(fronts[i],ans);
            if (set[backs[i]]) ans=Math.min(backs[i],ans );
        }
        return ans==1001?0:ans;
    }
}
