package easy;

public class kItemsWithMaximumSum {
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        if (numOnes>=k) return k;
        else {
            if (k-numOnes<=numZeros)return numOnes;
            else return numOnes-(k-numOnes-numZeros);
        }
    }
}
