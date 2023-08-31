package easy;

public class countEven {
    public int countEven(int num) {
        String[] arr=new String[Integer.toString(num).length()];
        int ans=0,count=0;
        while (num>1){
            ans=0;
            arr=Integer.toString(num).split("");
            num--;
            for (String i:arr){
                ans+=Integer.valueOf(i);
            }
            if (ans%2==0)count++;
        }
        return count;
    }
}
