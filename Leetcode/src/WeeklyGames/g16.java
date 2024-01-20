package WeeklyGames;

public class g16 {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int max=0,size=0;
        for (int i=0;i<dimensions.length;i++){
            int x=dimensions[i][0];
            int y=dimensions[i][1];
            if (x*x+y*y>max){
                max=x*x+y*y;
                size=x*y;
            }
            if (x*x+y*y==max){
                if (x*y>size) size=x*y;
            }
        }
        return size;
    }
    public int minMovesToCaptureTheQueen(int a, int b, int c, int d, int e, int f) {
        int cnt=100;
        int xe=Math.abs(c-e);
        int ye=Math.abs(d-f);
        if (xe%2==1){
            if (ye%2==1){
                if (xe==ye) {
                    cnt=1;
                    if ((d - b) != 0) {
                        if (Math.abs(c - a) ==Math.abs( d - b)) {
                            if ((((c - e) >0&& (c - a)>0)&& ((d - f) >0&& (d - b)>0))||
                                    (((d - f) <0 &&(d - b)<0)&&((c - e) <0&& (c - a)<0))||
                                    (((c - e) <0&& (c - a)<0)&& ((d - f) >0&& (d - b)>0))||
                                    (((c - e) >0&& (c - a)>0)&& ((d - f) <0&& (d - b)<0)))  {
                                if (Math.abs(c-a)<Math.abs(c-e)) cnt=2;

                            }
                        }
                    }

                }
                else cnt=2;
            }
        }else {
            if (ye%2==0){
                if (xe==ye) {
                    cnt=1;
                    if ((d - b) != 0) {
                        if (Math.abs(c - a) ==Math.abs( d - b)) {
                            if ((((c - e) >0&& (c - a)>0)&& ((d - f) >0&& (d - b)>0))||
                                    (((d - f) <0 &&(d - b)<0)&&((c - e) <0&& (c - a)<0))||
                                    (((c - e) <0&& (c - a)<0)&& ((d - f) >0&& (d - b)>0))||
                                    (((c - e) >0&& (c - a)>0)&& ((d - f) <0&& (d - b)<0)))  {
                                if (Math.abs(c-a)<Math.abs(c-e)) cnt=2;
                            }
                        }
                    }
                }
                else cnt=2;
            }
        }

        if (a==e){
            if (a!=c) cnt=1;
            else {
                if (((b-d)>0&&(b-f)>0)||((b-d)<0&&(b-f)<0)) {
                    if (Math.abs(b-d)<Math.abs(b-f)) {
                        cnt = Math.min(cnt, 2);
                    }else cnt=1;
                }else cnt=1;
            }
        }
        else if (b==f){
            if (b!=d) cnt=1;
            else {
                if (((a-c)>0&&(a-e)>0)||((a-c)<0&&(a-e)<0)) {
                    if (Math.abs(a-c)<Math.abs(a-e)) {
                        cnt = Math.min(cnt, 2);
                    }else cnt=1;
                }else cnt=1;
            }
        }
        else cnt=Math.min(cnt,2);
        return cnt;
    }
}
