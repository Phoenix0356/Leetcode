package easy;

public class freqAlphabet {
    public String freqAlphabets(String s) {
        StringBuilder sb=new StringBuilder();
        for (int i=0;i<s.length();i++){
            sb.append((char)( 'a'-'1'+s.charAt(i)));
            if (s.charAt(i)=='#'){
                sb.delete(sb.length()-3,sb.length());
                sb.append((char)( (s.charAt(i-2) - '0') * 10 + (s.charAt(i-1) - '1') + 'a'));
            }
        }
        return sb.toString();
    }
}
