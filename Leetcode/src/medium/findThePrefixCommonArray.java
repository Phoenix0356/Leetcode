package medium;

public class findThePrefixCommonArray {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int[] dict=new int[A.length+1];
        int[] C=new int[A.length];
        for (int i=0;i<A.length;i++){
            dict[B[i]]++;
            for (int j=0;j<=i;j++) {
                if (dict[A[j]] > 0) C[i] ++;

            }
        }
        return C;
    }
}
