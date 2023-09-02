package medium;

public class captureForts {
    public int captureForts(int[] forts) {
        int prev=0,count=0,max=0;
        for (int fort : forts) {
            if (fort != 0) {
                if (prev == -fort) {
                    max = Math.max(max, count);
                }
                prev = fort;
                count = 0;
                continue;

            }
            count++;

        }
        return max;
    }
}
