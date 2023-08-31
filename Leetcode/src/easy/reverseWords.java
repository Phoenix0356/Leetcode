package easy;

import java.util.Arrays;

public class reverseWords {
    public String reverseWords(String s) {
        StringBuilder sb=new StringBuilder(s);
        String[] arr=sb.reverse().toString().split(" ");
        for (int i=0;i<arr.length/2;i++){
            String s1=arr[i];
            arr[i]=arr[arr.length-1-i];
            arr[arr.length-1-i]=s1;
        }
        sb.delete(0,sb.length());
        for (String st:arr){
            sb.append(st);
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}
