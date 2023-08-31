package WeeklyGames;

import java.util.List;

public class g6 {
    public int countPairs(List<Integer> nums, int target) {
        int count=0;
        for (int i=0;i<nums.size();i++){
            for (int j=i+1;j<nums.size();j++){
                if (nums.get(i)+nums.get(j)<target) count++;
            }
        }
        return count;

    }
    public boolean canMakeSubsequence(String str1, String str2) {
        if (str1.length()==1&&str2.length()==1){
            return str2.charAt(0) == str1.charAt(0) ||
                    str2.charAt(0) == str1.charAt(0) + 1 ||
                    str2.charAt(0) == str1.charAt(0) - 25;
        }
        if (str2.length()>str1.length()) return false;

        int idx=0,count=0;
        for (int j=0;j<str1.length();j++){
            if (str2.charAt(idx)==str1.charAt(j)||
                    str2.charAt(idx)==str1.charAt(j)+1||
                    str2.charAt(idx)==str1.charAt(j)-25){
                idx++;
                count++;
                if (count==str2.length()) return true;
            }
        }
        return count==str2.length();
    }
    public int minimumOperations(List<Integer> nums) {
            int[] arr = nums.stream().mapToInt(i -> i).toArray();
            int n = arr.length;
            int[][] dp = new int[n+1][3];
            for (int i = 0; i<n; i++) {
                dp[i+1][0] = dp[i][0] + (arr[i]==1?0:1);
                dp[i+1][1] = Math.min(dp[i][0], dp[i][1]) + (arr[i]==2?0:1);
                dp[i+1][2] = Math.min(Math.min(dp[i][0], dp[i][1]), dp[i][2]) + (arr[i]==3?0:1);
            }
            return Math.min(Math.min(dp[n][0], dp[n][1]), dp[n][2]);
        }
}
