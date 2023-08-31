package hard;

public class numberOf2sInRange {
    public int numberOf2sInRange(int n) {
        if (n<=11)return 1;
        int count=0;
        boolean isCounted=false;
        while (n>0) {
            if (!String.valueOf(n).contains("2")) {
                if (n % 10 > 2) {
                    count++;
                }
                n = n - n % 10 - 1;
            }else{
                int numOf2=0;
                String s=String.valueOf(n);
                if (isCounted==false){
                for (int i=0;i<s.length();i++) {
                    if (Character.compare(s.charAt(i), '2') == 0) ;
                    numOf2++;
                }
                isCounted=true;
                }else {
                    count=(n%10+1)*numOf2;
                    n=n-n%10-1;
                }
            }
        }
        return count;
    }
}
