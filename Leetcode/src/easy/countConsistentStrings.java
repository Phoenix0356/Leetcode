package easy;

public class countConsistentStrings {
    public int countConsistentStrings(String allowed, String[] words) {
        int cnt=0;
        for(int i=0;i<words.length;i++){
            for (int j=0;j<words[i].length();j++){
                int flag=0;
                for (int k=0;k<allowed.length();k++){
                    if (words[i].charAt(j)==allowed.charAt(k)){
                        flag++;
                    }
                }
                if (flag==words[i].length())cnt++;
            }
        }
        return cnt;
    }
}
