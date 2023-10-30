package easy;

public class pickGifts {
    public long pickGifts(int[] gifts, int k) {
        long sum=0;
        while (k-- > 0) {
            int max=0,idx=0;
            for (int i=0;i<gifts.length;i++){
                if (gifts[i]>max) {
                    max=gifts[i];
                    idx=i;
                }
            }
            gifts[idx]=(int) Math.sqrt(gifts[idx]);
        }
        for (int n:gifts) sum+=n;
        return sum;
    }
}
