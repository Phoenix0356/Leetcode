package WeeklyGames;

import java.util.HashSet;
import java.util.List;

public class g8 {
    public int furthestDistanceFromOrigin(String moves) {
        int num=0,num_=0;
        for (int i=0;i<moves.length();i++){
            if (moves.charAt(i)=='L')num--;
            else if (moves.charAt(i)=='R') num++;
            else num_++;
        }
        if (num>=0)num+=num_;
        else num=Math.abs(num-num_);
        return num;
    }
    public long minimumPossibleSum(int n, int target) {
        int[] nums=new int[n];
        HashSet<Integer> set=new HashSet<>();
        int neg=target-1;
        long sum=0;
        for (int i=0;i<n;i++){
            int temp=target-neg--;
            if (!set.contains(temp))sum+=temp;
            else {
                i--;
                continue;
            }
            set.add(target-temp);
        }
        return sum;
    }
    int max=0;
    List<Integer> re;
    public long getMaxFunctionValue(List<Integer> receiver, long k) {
        int sum=0;
        re=receiver;
        for (int i=0;i<receiver.size();i++){
            dfs(i,k);
            sum=Math.max(sum,max);
            max=0;
        }
        return sum;
    }
    void dfs(int i,long k){
        if (k==0) return;
        max+=re.get(i);
        dfs(re.get(i),k-1);
    }
}
