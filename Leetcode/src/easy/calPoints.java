package easy;

public class calPoints {
    public int calPoints(String[] ops) {
        int[] res = new int[ops.length];
        int ans = 0, count = 0;
        for (int i = 0; i < ops.length; i++) {
            if (ops[i].equals("+")) {
                res[count] = res[count - 1] + res[count - 2];
                count++;
            } else if (ops[i].equals("D")) {
                res[count] = res[i - 1] * 2;
                count++;
            } else if (ops[i].equals("C")) {
                res[count - 1] = 0;
                count--;
            } else {
                res[count++] = Integer.valueOf(ops[i]);
            }
        }
        for (int i:res){
            ans+=i;
        }
        return ans;
    }
}
