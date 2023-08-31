package medium;

import java.util.Arrays;
import java.util.Comparator;

public class maximumWhiteTiles {
    public int maximumWhiteTiles(int[][] tiles, int carpetLen) {
        int[] tile=new int[2*tiles.length-1];
        Arrays.sort(tiles, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        tile[0]=tiles[0][1]-tiles[0][0]+1;
        int idx=0;
        for (int i=1;i<tiles.length;i++){
            tile[++idx]=tiles[i][0]-tiles[i-1][1]-1;
            tile[++idx]=tiles[i][1]-tiles[i][0]+1;
        }

        int start=0,res=0;
        int remain=0;
        int sum=tile[start],tileLen=tile[start];
        if (sum>carpetLen) return carpetLen;
        while (tileLen<carpetLen){
            if (++start==tile.length) return Math.max(res, sum);
            tileLen+=tile[start];
            if (start%2==0){
                remain=tile[start]-(tileLen-carpetLen);
                sum=tileLen>carpetLen?sum+remain:sum+tile[start];
            }
        }
        res=sum;
        System.out.println(sum);
        for (int i=2;i<tile.length;i+=2){
            tileLen=tileLen-tile[i-1]-tile[i-2];
            sum-=tile[i-2];
            if (start % 2 == 0) {
                sum-=remain;
                tileLen-=tile[start];
                --start;
            }
            while (tileLen<carpetLen){
                if (++start==tile.length) return Math.max(res, sum);
                tileLen+=tile[start];
                if (start%2==0){
                    remain=tile[start]-(tileLen-carpetLen);
                    sum=tileLen>carpetLen?sum+remain:sum+tile[start];
                }
            }
            res=Math.max(sum,res);
        }
        return res;
    }
}
