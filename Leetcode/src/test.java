import algorithm.Sort;

import java.util.Random;

public class test {

    public static void main(String[] args) {
        String a = new String("abc");
        a=a.intern();
        String b = "abc";
        System.out.println(a==b);
    }


}
