package easy;

public class strStr {
    public int strStr(String haystack, String needle) {
        int res=0;
        if (haystack.contains(needle)){
            while (haystack.contains(needle)){
                res=haystack.indexOf(needle);
            }
        }else return -1;

        return res;
    }
}
