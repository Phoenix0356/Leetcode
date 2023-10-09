package medium;

public class maxProfitWithFee {
    public int maxProfit(int[] prices, int fee) {
        int hold=-prices[0];
        int sold=0;
        for (int i=1;i<prices.length;i++){
            hold=Math.max(hold,sold-prices[i]);
            sold=Math.max(sold,hold+prices[i]-fee);
        }
        return sold;
    }
}
