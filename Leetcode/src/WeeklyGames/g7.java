package WeeklyGames;

import java.util.List;

public class g7 {
    public boolean isAcronym(List<String> words, String s) {
        if (s.length()!=words.size()) return false;
        for (int i=0;i<s.length();i++){
            if (s.charAt(i)!=words.get(i).charAt(0))return false;
        }
        return true;
    }
    public int minimumSum(int n, int k) {
        int neg=k;
        int[] nums=new int[10000];
        int[] pos=new int[n];
        for (int i=0;i<pos.length;i++){
            neg--;
            if (nums[k-neg]!=0) {
                i--;
                continue;
            }
            pos[i]=k-neg;
            if (i<=k) nums[neg]--;

        }
        int sum=0;
        for (int i:pos){
            sum+=i;
        }
        return sum;
    }
//    public int maximizeTheProfit(int n, List<List<Integer>> offers) {
//        double[][] price=new double[offers.size()+1][n];
//        int row=1;
//        for (List<Integer> l:offers){
//            int start=l.get(0),end=l.get(1);
//            double money=l.get(2);
//            for (int i=start;i<=end;i++){
//
//            }
//        }
//    }

}
