package medium;

public class repairCars {
    public long repairCars(int[] ranks, int cars) {
        long l=1,r= (long) ranks[0] * cars * cars;
        while (l<r){
            long m=l+r>>1;
            if (isFinished(ranks,cars,m)){
                r=m;
            }else {
                l=m+1;
            }
        }
        return l;
    }

    public boolean isFinished(int[] ranks,int cars,long times){
        int cnt=0;
        for (int n:ranks){
            cnt+=(long)Math.sqrt(times/n);
        }
        return cnt>=cars;
    }

}
