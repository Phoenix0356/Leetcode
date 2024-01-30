package easy;

import java.util.ArrayList;

public class countSymmetricIntegers {
    public int countSymmetricIntegers(int low, int high) {
        int ans=0;
        for (int i=low;i<=high;i++){
            ans+=judge(i)?1:0;
        }
        return ans;
    }
    private boolean judge(int n){
        int sum = 0;
        ArrayList<Integer> list = new ArrayList<>();
        while (n>0){
            list.add(n%10);
            n/=10;
        }
        if (list.size()%2!=0) return false;
        for (int i=0;i < list.size()/2;i++){
            sum=sum+list.get(i) - list.get(list.size()-1-i);
        }
        return sum==0;
    }
}
