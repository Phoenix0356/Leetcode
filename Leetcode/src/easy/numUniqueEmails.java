package easy;

import java.util.HashSet;
import java.util.Set;

public class numUniqueEmails {
    public int numUniqueEmails(String[] emails) {
        Set<String> set=new HashSet<>();
        for (String s:emails){
            outer:for (int i=0;i<s.length();i++){
                if (s.charAt(i)=='.'){
                    s=new StringBuffer(s).delete(i,i+1).toString();
                    continue;
                }
                if (s.charAt(i)=='+'){
                    for (int j=i+1;j<s.length();j++){
                        if (s.charAt(j)=='@'){
                            s=new StringBuffer(s).delete(i,j).toString();
                        }
                    }
                }
                if (s.charAt(i)=='@'){
                    break outer;
                }
            }
            set.add(s);
        }
        return set.size();
    }
}
