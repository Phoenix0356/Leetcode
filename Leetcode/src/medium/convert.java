package medium;

public class convert {
    public String convert(String s, int numRows) {
        if(numRows==1){return s;}
        StringBuilder ans=new StringBuilder();
        for(int i=0;i<s.length();i+=(numRows-1)*2){ans.append(s.charAt(i));}
        for(int i=1;i<numRows-1;i++){
            for(int j=0;j*(numRows-1)*2+i<s.length();j++){
                ans.append(s.charAt(j*(numRows-1)*2+i));
                int r=(j+1)*(numRows-1)*2-i;
                if(r<s.length()){ans.append(s.charAt(r));}
            }
        }
        for(int i=numRows-1;i<s.length();i+=(numRows-1)*2){ans.append(s.charAt(i));}
        return ans.toString();
    }
}
