package medium;

public class missingRolls {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int[] arr=new  int[n];
        int[] nullArr=new int[0];
        int m= rolls.length,l=n,sum=0;
        for (int i:rolls){
            sum+=i;
        }
        int sumOfN=mean*(m+n)-sum;
        if (sumOfN>n*6||sumOfN<n)return nullArr;
        for (int i=0;i<l;i++){
            if (sumOfN%n==0) arr[i]=sumOfN/n;
            else {
                arr[i]=sumOfN/n+1;
                sumOfN-=arr[i];
                n--;
            }
        }
        return arr;
    }
}
