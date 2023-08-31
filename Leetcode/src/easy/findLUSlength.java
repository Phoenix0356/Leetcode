package easy;

public class findLUSlength {
    public int findLUSlength(String a, String b) {
        if (a.equals(b))return -1;
        int count=a.length()>=b.length()?a.length():b.length();
        int num=a.length()<=b.length()?a.length():b.length();
        for (int i=0;i<num;i++){
            inner:for (int j=0;j<num;j++) {
                if (String.valueOf(a.charAt(i)).equals(b.charAt(j))){
                    count--;
                    break inner;
                }
            }
        }
        return count==0?-1:count;
    }
}
