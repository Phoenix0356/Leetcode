package WeeklyGames;

public class g3 {
    public boolean haveConflict(String[] event1, String[] event2) {
        boolean isConf1=false;
        boolean isConf2=false;
        String[] time1=event1[1].split(":");
        String[] time4=event1[0].split(":");
        String[] time2=event2[0].split(":");
        String[] time3=event2[1].split(":");
        if (Integer.parseInt(time1[0]) == Integer.parseInt(time2[0])) {
            isConf2 = Integer.parseInt(time1[1]) >= Integer.parseInt(time2[1]);
        }
        if (Integer.parseInt(time1[0]) == Integer.parseInt(time3[0])) {
            isConf2 = Integer.parseInt(time1[1]) <= Integer.parseInt(time3[1]);
        }
        if (Integer.parseInt(time4[0]) == Integer.parseInt(time2[0])) {
            isConf1 = Integer.parseInt(time4[1]) >= Integer.parseInt(time2[1]);
        }
        if (Integer.parseInt(time4[0]) == Integer.parseInt(time3[0])) {
            isConf1 = Integer.parseInt(time4[1]) <= Integer.parseInt(time3[1]);
        }
        boolean isConf5=Integer.parseInt(time1[0])>Integer.parseInt(time2[0])&&Integer.parseInt(time1[0])<Integer.parseInt(time3[0]);
        boolean isConf4=Integer.parseInt(time4[0])>Integer.parseInt(time2[0])&&Integer.parseInt(time4[0])<Integer.parseInt(time3[0]);
        boolean isConf3=Integer.parseInt(time4[0])<Integer.parseInt(time2[0])&&Integer.parseInt(time1[0])>Integer.parseInt(time3[0]);

        return isConf1||isConf2||isConf3||isConf4||isConf5;

    }

    public int subarrayGCD(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == k ) {
                count++;
            }
            if (nums[i] % k == 0) {
                for (int ind=i+1; ind < nums.length; ind++) {
                    if (nums[i]==k&&nums[ind]%k==0){
                        count++;
                    }
                    else if (nums[ind] % k == 0 && (Math.abs(nums[ind] - nums[i]) / k) % 2 == 1) {
                        count++;
                    } else break;

                }
            }
        }
        return count;
    }
}
