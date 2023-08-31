package easy;

public class lemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        int five=0,ten=0;
        for (int n:bills){
            if (n==5) five++;
            else if (n==10) {
                ten++;
                five--;
            }
            else {
                if (ten>0) {
                    ten--;
                    five--;
                }
                else five-=3;
            }
            if (five<0||ten<0) return false;
        }
        return true;
    }
}
