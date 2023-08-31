package easy;

public class reverseOnlyLetters {
    public String reverseOnlyLetters(String s) {
        char[] arr=s.toCharArray();

        int start=0,end=s.length()-1;
        while(start<end){
            if (!Character.isAlphabetic(arr[start])){
                start++;
                continue;
            }
            if (!Character.isAlphabetic(arr[end])){
                end--;
                continue;
            }
            char temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;end--;
        }
        String ans=String.copyValueOf(arr);
        return ans;
    }
}
