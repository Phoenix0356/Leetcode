package easy;

public class canPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed.length==1){
            return n<=1-flowerbed[0];
        }
        int cnt=0,ans=0;
        if (flowerbed[0]==0&&flowerbed[1]==0){
            ans++;
            flowerbed[0]=1;
        }
        if (flowerbed[flowerbed.length-1]==0&&flowerbed[flowerbed.length-2]==0){
            ans++;
            flowerbed[flowerbed.length-1]=1;
        }
        for (int j : flowerbed) {
            if (j == 0) {
                cnt++;
            } else cnt = 0;
            if (cnt == 3) {
                ans++;
                cnt = 1;
            }
        }
        return ans>=n;
    }
}
