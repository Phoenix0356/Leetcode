package easy;

import java.util.Arrays;

public class areAlmostEqual {
    public boolean areAlmostEqual(String s1, String s2) {
        boolean[] flag=new boolean[s1.length()];
        char[] c1=s1.toCharArray();
        char[] c2=s2.toCharArray();
        int count=0;
        char save;
        for (int i=0;i<s1.length();i++){
            if (c1[i]!=c2[i]){
                flag[i]=true;
                count++;
            }
        }
        if (count>2) return false;
        for (int i=0;i<flag.length;i++){
            if (flag[i]){
                for (int j=i+1;j< flag.length;j++){
                    if (flag[j]){
                        save=c1[i];
                        c1[i]=c1[j];
                        c1[j]=save;
                        break;
                    }
                }
            }
        }
        return Arrays.toString(c1).equals(Arrays.toString(c2));
    }
}
