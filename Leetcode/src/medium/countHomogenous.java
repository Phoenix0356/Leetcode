package medium;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class countHomogenous {
    ArrayList<Integer> dic=new ArrayList<>();
    Map<Integer,Integer> map=new HashMap<>();
    public int countHomogenous(String s) {
        dic.add(1);
        map.put(1,1);
        int ans=0,ind=1,count=1;

        while (ind<s.length()){
            if (s.charAt(ind-1)==s.charAt(ind)){
                count++;
                ind++;
            }else{
                ind++;
                ans+=calc(count);
                count=1;
            }
        }
        ans+=calc(count);
        return ans;
    }
    public long calc(int n){
        if (map.containsKey(n)){
            return map.get(n);
        }
        int diff=Integer.MAX_VALUE;
        for (int i=0;i<dic.size();i++) {
            if (Math.abs(dic.get(i) - n)<Math.abs(diff)) {
                diff = n-dic.get(i) ;
            }
        }
        long num=map.get(n-diff);
        do{
            if(diff>0) {
                num += n - --diff;
            }else {
                num -= n - diff++;
            }
        } while (diff!=0);
        dic.add(n);
        map.put(n,(int)(num%1000000007));
        return map.get(n);
    }
}
