package easy;

public class lengthOfLastWord {
    public int lengthOfLastWord(String s) {
        String[] arr=s.split(" ");
        return arr[arr.length-1].length();
    }
}
