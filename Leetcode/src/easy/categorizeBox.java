package easy;

public class categorizeBox {
    public String categorizeBox(int length, int width, int height, int mass) {
        boolean isBulky=false,isHeavy=false;
        long size= (long) length *width*height;
        if (size>=10e9||(length>=10e4||width>=10e4||height>=10e4)) isBulky=true;
        if (mass>=100) isHeavy=true;

        System.out.println(isHeavy+" "+isBulky);
        if (isHeavy&&!isBulky) return "Heavy";
        else if (!isHeavy&&isBulky) return "Bulky";
        else if (isHeavy)  return "Both";
        else return "Neither";

    }
}
