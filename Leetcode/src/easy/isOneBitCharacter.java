package easy;

public class isOneBitCharacter {
    public boolean isOneBitCharacter(int[] bits) {
        int n=bits.length;
        int cnt=0;
        if (n==1)return true;
        if (bits[n-2]==0)return true;
        for (;n>=0;n--){
            if (bits[n-2]==1){
                cnt++;
            }else {break;}
        }
        return cnt%2==0?true:false;
    }
}
