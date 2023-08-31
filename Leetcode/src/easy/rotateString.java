package easy;

public class rotateString {
    public boolean rotateString(String s, String goal) {
        if (s.length()!=goal.length())return false;
        int ind=0;
        boolean isFind=false;
        for (;ind<s.length();ind++){
            if (s.charAt(ind) == goal.charAt(0)){
                isFind=true;
                break;
            }
        }
        if (isFind==false)return false;
        for (int i=1;i<goal.length();i++){
            if (ind==s.length()-1) ind=-1;
            if (s.charAt(++ind) != goal.charAt(i)){
                return false;
            }
        }
        return true;
    }
}
