package medium;

import java.util.ArrayList;
import java.util.Arrays;

public class successfulPairs {

        public int[] successfulPairs(int[] spells, int[] potions, long success) {

            int[] nums=new int[spells.length];
            int ind=0;
            Arrays.sort(potions);
            for (int spell : spells) {
                int left=0,right= potions.length;
                int mid=-1;
                while (left<right){
                    mid=(left+right)>>1;
                    if ((long) spell *potions[mid]>=success)right=mid;
                    else left=mid+1;
                }
                if (left==potions.length) nums[ind++]=0;
                else nums[ind++]= potions.length-left;
            }

            return nums;

    }
}
