package medium;

public class complexNumberMultiply {
    public String complexNumberMultiply(String num1, String num2) {
       String[] arr=(num1+num2).split("\\+|i");
       int num=Integer.valueOf(arr[0])*Integer.valueOf(arr[2])-Integer.valueOf(arr[1])*Integer.valueOf(arr[3]);
       int i=Integer.valueOf(arr[0])*Integer.valueOf(arr[3])+Integer.valueOf(arr[1])*Integer.valueOf(arr[2]);
        return Integer.toString(num)+"+"+Integer.toString(i)+"i";
    }
}
