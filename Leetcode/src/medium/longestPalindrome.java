package medium;

public class longestPalindrome {
    public String longestPalindrome(String s) {
        String ans = "";
        for (int i = 0;i < s.length();i++){
            String s1 = findPalindrome(s,i,i);
            String s2 = findPalindrome(s,i,i+1);

            ans = ans.length()>s1.length()?ans:s1;
            ans = ans.length()>s2.length()?ans:s2;
        }
        return ans;
    }
    public String findPalindrome(String s,int mid1,int mid2){
        while (mid1>=0 && mid2<s.length()){
            if (s.charAt(mid1) == s.charAt(mid2)){
                mid1--;
                mid2++;
            }else break;
        }
        return s.substring(mid1+1,mid2);
    }

}
