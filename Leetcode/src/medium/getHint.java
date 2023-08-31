package medium;

import java.util.HashSet;

public class getHint {
    public String getHint(String secret, String guess) {
        int[] flag=new int[10];
        int bulls=0,cows=0;
        for (int i=0;i<secret.length();i++){
            int f1=secret.charAt(i)-'0';
            int f2=guess.charAt(i)-'0';
            if (f1==f2) bulls++;
            else {
                if (flag[f1]++ < 0) cows++;
                if (flag[f2]-- > 0) cows++;
            }
        }

        return new StringBuilder().append(bulls).append('A').append(cows).append('B').toString();


    }
}
