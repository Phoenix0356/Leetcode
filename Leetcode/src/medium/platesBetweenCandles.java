package medium;

import java.util.Arrays;

public class platesBetweenCandles {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        char[] c=s.toCharArray();
        int[] cor=new int[s.length()];
        int[] res=new int[queries.length];
        int count=0;
        int start=0,end=1;
        for (;end<s.length();end++){
            if (Character.compare(c[start],'|')==0&&Character.compare(c[end],'|')!=0) {
                cor[start]++;
            } else {
                start=end;

            }
        }
        for (int[] sub:queries){
            int[] temp=new int[sub[1]-sub[0]+1];
            System.arraycopy(cor,sub[0],temp,0,temp.length);
            Arrays.sort(temp);
            res[count++]=temp[temp.length-1];
        }
        return res;
    }
}
