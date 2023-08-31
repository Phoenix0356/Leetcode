import javax.swing.text.StyleContext;
import java.util.Arrays;

public class makesquare {
    public boolean makesquare(int[] matchsticks) {
        int length = 0, cur = 0, count = 0;
        boolean[] flag = new boolean[matchsticks.length];
        for (int i : matchsticks) {
            length += i;
        }
        if (length % 4 != 0) return false;
        length /= 4;
        cur = length;
        Arrays.sort(matchsticks);
        while (count++ < 4) {
            if (dfs(flag,matchsticks,length)==false) return false;
        }
        return true;
    }

    public boolean dfs(boolean[] flag, int[] arr, int aim) {
        int save=aim;
        int i=arr.length-1;
        for (;i>=0; i--) {
            if (aim >= arr[i] && flag[i] == false) {
                aim -= arr[i];
                flag[i] = true;
                if (dfs(flag, arr, aim)==true){
                    return true;
                }else {
                    flag[i]=false;
                }
                aim=save;
            }
            if (aim==0){
                return true;
            }
        }
        return false;
    }
}

