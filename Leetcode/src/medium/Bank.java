package medium;

public class Bank {

    long[] act;
    public Bank(long[] balance) {
        this.act=balance;
    }

    public boolean transfer(int account1, int account2, long money) {
        if (account1-1>act.length||account2-1>act.length) return false;
        if (act[account1-1]-money<0) return false;
        act[account1-1]-=money;
        act[account2-1]+=money;
        return true;
    }

    public boolean deposit(int account, long money) {
        if (account-1>act.length) return false;
        act[account-1]+=money;
        return true;
    }

    public boolean withdraw(int account, long money) {
        if (account-1>act.length) return false;
        if (act[account-1]-money<0) return false;
        act[account-1]-=money;
        return true;
    }
}
