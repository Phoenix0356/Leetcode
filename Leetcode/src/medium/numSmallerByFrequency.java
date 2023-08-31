package medium;

public class numSmallerByFrequency {
    int[] count(String[] s){

        int[] num=new int[s.length];
        for (int i=0;i<s.length;i++){
            int cnt=1;
            char c=s[i].charAt(0);
            for (int j=1;j<s[i].length();j++){
                if (c>s[i].charAt(j)){
                    cnt=1;
                    c=s[i].charAt(j);
                }else if (c==s[i].charAt(j))cnt++;
            }
            num[i]=cnt;
        }
        return num;

    }
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] qNum=count(queries);
        int[] wNum=count(words);
        int[] ans=new int[queries.length];
        for (int i=0;i<qNum.length;i++){
            for (int k : wNum) {
                if (qNum[i] < k) {
                    ans[i]++;
                }
            }
        }
        return ans;
    }
}
