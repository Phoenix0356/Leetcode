package easy;

public class maxProfit {
    public int maxProfit(int[] prices) {
        int w=0,cnt=0;
        for (int i=1;i<prices.length;i++){
            if (prices[cnt]<prices[i]){
                w=Math.max(w,prices[i]-prices[cnt]);
            }else {
                cnt=i;
            }

        }
        return w;
    }
}
