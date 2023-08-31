package medium;

public class minimalKSum {
    public long minimalKSum(int[] nums, int k) {

        int numOfOccupied=compare(0,k,nums,0);
        System.out.println(numOfOccupied);
        long sum=count(0,k+numOfOccupied);
        for (int n:nums){
            if (n<k+numOfOccupied) sum-=n;
        }
        return sum;
    }
    public long count(int start,int end){
        if (start==end) return 0;
        int sum=0;
        for (int i=start;i<end;i++){
            sum+=i+1;
        }
        return sum;
    }
    public int compare(int start,int end,int[] nums,int numOfOccupied){
        int inc=0;
        for(int n:nums){
            if (n<=end&&n>start) {
                inc++;
            }
        }
        if (inc==0) return numOfOccupied;
        return compare(end,end+inc,nums,numOfOccupied+inc);
    }
}
