package WeeklyGames;

public class g1 {
    public int countTime(String time) {
        char[] arr=time.toCharArray();
        boolean[] flag=new boolean[5];
        boolean isCount=false;
        int cnt=1;
        for (int i=0;i<arr.length;i++){
            if (arr[i]=='?'){
                flag[i]=true;
                }
            }
        if (flag[0]&&flag[1]){
            isCount=true;
            cnt*=24;
        }
        if (!isCount&&flag[0]&& Integer.parseInt(String.valueOf( arr[1])) <4)cnt*=3;
        if (!isCount&&flag[0]&& Integer.parseInt(String.valueOf( arr[1])) >3)cnt*=2;
        if (!isCount&&flag[1]&&Integer.parseInt(String.valueOf( arr[0]))<2)cnt*=10;
        if (!isCount&&flag[1]&&Integer.parseInt(String.valueOf( arr[0]))==2)cnt*=5;
        if (flag[3])cnt*=6;
        if (flag[4])cnt*=10;

        return cnt;
    }
}
