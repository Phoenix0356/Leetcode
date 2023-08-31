package medium;

public class lengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s.length()==0)return 0;
        if (s.length()==1)return 1;
        if (s.length()==2&&s.charAt(0)==s.charAt(1))return 1;
        String[] arr = s.split("");
        int res = 1;
        String temp = arr[0];
        for (int j = 1; j < arr.length; j++) {
            if (temp.contains(arr[j])) {
                if (temp.length() > res)res=temp.length();
                inner:for (int i=0;i < temp.length();) {
                        if (String.valueOf(temp.charAt(i)).equals(arr[j])) {
                            temp = temp.substring(i + 1, temp.length()) + arr[j];
                            break inner;
                        } else {
                         i++;
                        }
                    }
                } else {
                    temp += arr[j];
                }
            }
       return  res>temp.length()?res:temp.length();
    }
}
