package WeeklyGames;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class g12 {
    public List<Integer> findWordsContaining(String[] words, char x) {
        ArrayList<Integer> list=new ArrayList<>();
        for (int i=0;i< words.length;i++){
            for (int j=0;j<words[i].length();j++){
                if (words[i].charAt(j)==x) {
                    list.add(i);
                    break;
                }
            }
        }
        return list;
    }
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        Arrays.sort(hBars);
        Arrays.sort(vBars);
        int maxH = 1, maxV = 1;
        maxH=count(hBars,n);
        maxV=count(vBars,m);
        return Math.min(maxH, maxV) * Math.min(maxH, maxV);
    }
    public int count(int[] nums,int n) {
        int[] num=new int[nums.length+2];
        System.arraycopy(nums, 0, num, 1, nums.length);
        num[0]=1;
        num[num.length-1]=n+2;
        int max=1,ans=0;
        if (nums.length>1) {
            for (int i = 1; i < num.length-1; i++) {
                if (num[i]-num[i-1]==1){
                    max++;
                }else {
                    ans=Math.max(ans,max);
                    max=2;
                }
            }
            return Math.max(ans,max);
        }else return 2;
    }

}
