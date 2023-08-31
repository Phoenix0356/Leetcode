package easy;

import java.util.*;

public class intersect {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list=new ArrayList<>();
        for (int i=nums1.length-1;i>=0;i--){
            for (int j=nums2.length-1;j>=0;j--){
                if (nums1[i]==nums2[j]){
                    list.add(nums1[i]);
                    nums2[j]=-1;
                    break;
                }
            }
        }
        int[] res=new int[list.size()];
        for (int i=0;i<res.length;i++){
            res[i]=list.get(i);
        }
        return res;
    }
}
