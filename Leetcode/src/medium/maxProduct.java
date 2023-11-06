package medium;

public class maxProduct {
    public int maxProduct(String[] words) {
        int[] mask= new int[words.length];
        int max=0;
        for (int i=0;i< words.length;i++){
            for (int j=0;j<words[i].length();j++){
                mask[i]|=1<<(words[i].charAt(j)-'a');
            }
        }
        for (int i=0;i< words.length;i++){
            for (int j=i+1;j< words.length;j++){
                if ((mask[i]&mask[j])==0){
                    max=Math.max(max,words[i].length()*words[j].length());
                }
            }
        }
        return max;
    }
}
