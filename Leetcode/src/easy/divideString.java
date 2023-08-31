package easy;

public class divideString {
    public String[] divideString(String s, int k, char fill) {
        int ind=0,l=s.length();
        String[] arr=new String[l%k==0?l/k:l/k+1];
        for (int i=0;i+k>=s.length();){
                arr[ind++]=s.substring(i,i+k);
                s=new StringBuffer(s).delete(i,i+k).toString();
        }
        if (s.length()!=0){
            arr[++ind]=s;
            for (int i=0;i+s.length()<k;i++){
                arr[ind]+=fill;
            }
        }
        return arr;
    }
}
