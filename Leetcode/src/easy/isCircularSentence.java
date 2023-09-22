package easy;

public class isCircularSentence {
    public boolean isCircularSentence(String sentence) {
        String[] s=sentence.split(" ");
        String cur=s[0];
        if (s.length==1) return s[0].charAt(s[0].length()-1)==s[0].charAt(0);
        for (int i=1;i<s.length;i++){
            if (cur.charAt(cur.length()-1)!=s[i].charAt(0)) return false;
            cur=s[i];
            if (i==s.length-1) return s[i].charAt(s[i].length()-1)==s[0].charAt(0);

        }
        return true;
    }
}
