package easy;

public class arraySign {
    public int arraySign(int[] nums) {
       boolean isNeg=false;
        for (int num : nums) {
            if (num == 0) return 0;
            if (num<0) isNeg=!isNeg;
        }
        return isNeg?1:-1;
    }
}
