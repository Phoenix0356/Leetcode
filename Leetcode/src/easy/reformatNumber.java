package easy;

public class reformatNumber {
    public String reformatNumber(String number) {
        StringBuilder temp=new StringBuilder(number.replace(" ","").replace("-",""));
        if (temp.length()==4){
            temp.insert(2,"-");
            return temp.toString();
        }
        int num=temp.length()/3,mod=temp.length()%3;
        for (int i=1;i<num+1;i++){
            if (3*i+i-1==temp.length()-4){
                temp.insert(3*i+i-1,"-");
                temp.insert(3*i+i+2,"-");
                break;
            }
            temp.insert(3*i+i-1,"-");
        }
        if (temp.lastIndexOf(String.valueOf('-'))==temp.length()-1){
            temp.delete(temp.length()-1,temp.length());
        }
        return temp.toString();
    }
}
