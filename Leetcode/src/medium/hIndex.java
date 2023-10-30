package medium;

public class hIndex {
    public int hIndex(int[] citations) {
        int len=citations.length,h=0;
        for (int i=len-1;i>=0;i--){
            if (++h>citations[i]) {
                h--;
                break;
            }
        }
        return h;
    }
}
