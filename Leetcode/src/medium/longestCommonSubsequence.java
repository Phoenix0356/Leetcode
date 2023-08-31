package medium;

public class longestCommonSubsequence {
    int a=0;
   void compare(StringBuilder sLong,StringBuilder sShort,int pre){
        int ans=0,ind=0;
        for (int j=0;j<sShort.length();j++) {
            for (int i = ind; i < sLong.length(); i++) {
                if (sShort.charAt(j) == sLong.charAt(i)) {
                    ans++;
                    sLong.delete(i,i+1);
                    ind=i;
                    sShort.delete(j,j+1);
                    j--;
                    break;
                }
            }
        }
        if (ans==0) return;
        //if (sShort.length()==0) return Math.max(pre,ans);
        a= Math.max(pre,ans);
        compare(sLong,sShort,a);

    }
     public int longestCommonSubsequence(String text1, String text2) {
        StringBuilder sb1=new StringBuilder(text1);
        StringBuilder sb2=new StringBuilder(text2);

        if (text1.length()>=text2.length()){
            compare(sb1,sb2,0);
        }else compare(sb2,sb1,0);
        return a;
    }
}
