package medium;

public class maxProfit {
    public int maxProfit(int[] prices) {
        int cur=prices[0],p=0;
        for (int i=1;i<prices.length;i++){
            if (prices[i]>cur){
                p+=prices[i]-cur;
            }
            cur=prices[i];

        }
        return p;
    }
}
