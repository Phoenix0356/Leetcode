package medium;

import java.util.HashMap;

public class twoSum {
    public int[] twoSum(int[] numbers, int target) {
        int ind1=0,ind2=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i=0;i< numbers.length;i++) map.put(numbers[i],i);
        for (int i=0;i< numbers.length;i++){
            int tar=target-numbers[i];
            if (map.containsKey(tar)&&map.get(tar)!=i) {
                ind1=Math.min(map.get(tar),i);
                ind2=Math.max(map.get(tar),i);
            }
        }
        return new int[]{ind1+1,ind2+1};
    }
}
