package easy;

import java.util.HashSet;

public class addDigits {
    public int addDigits(int num) {
        HashSet<Integer> set = new HashSet<>();
        int ans=0;
        while (num!=0){
            ans+=num%10;
            num/=10;
            if (ans>=10){
                ans=ans-9;
            }
        }
        return ans;
    }

}
