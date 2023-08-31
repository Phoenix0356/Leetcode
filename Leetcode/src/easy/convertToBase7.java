package easy;

public class convertToBase7 {
    public String convertToBase7(int num) {
        if (num==0)return "0";
        StringBuilder sb = new StringBuilder();
        if (num>0) {
            while (num != 0) {
              sb.append(String.valueOf(num % 7));
                num /= 7;
            }
        }else {
            num=-num;
            while (num != 0) {
                sb.append(String.valueOf(num % 7));
                num /= 7;
            }
            sb.append("-");
        }
        return sb.reverse().toString();
    }
}
