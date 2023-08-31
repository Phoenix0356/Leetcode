package easy;

public class numberOfLines {
    public int[] numberOfLines(int[] widths, String s) {
        int line=0,count=1;
        for (int i=0;i<s.length();i++){
            line+=widths[s.charAt(i)-'a'];
            if (line>100){
                count++;
                line=widths[s.charAt(i)-'a'];
            }
        }
        int[] res={count,line};
        return res;

    }
}
