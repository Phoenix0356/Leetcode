package medium;

public class maxDistToClosest {
    public int maxDistToClosest(int[] seats) {
        int ind=0,dis=0,max=0;
        int[] dist=new int[seats.length+2];
        for (int i=0;i<seats.length;i++) {
            dis++;
            if (seats[i] == 1) {
                if (i==0) {
                    ind++;
                    continue;
                }
                dist[ind++]=dis;
                dis = 0;
            }
        }
        dist[ind]=dis;
        max=Math.max(dist[0],dist[ind]);
        for (int i=0;i<=ind;i++){
            System.out.println(dist[i]);
            if (dist[i]/2>max)max= dist[i];
        }
        return max;
    }
}
