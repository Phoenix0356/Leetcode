package easy;

public class reverseString {
    public void reverseString(char[] s) {
        char temp;
        int l=s.length,len=l%2==0?l/2:l/2+1;
        for (int i=0;i<len;i++){
            temp=s[i];
            s[i]=s[l-1-i];
            s[l-1-i]=temp;
        }
    }
}
