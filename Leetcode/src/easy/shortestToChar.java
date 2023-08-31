package easy;

public class shortestToChar {
    public int[] shortestToChar(String s, char c) {
        int n = s.length();
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            boolean flag1=false,flag2=false;
            int dis = 0,dis2 = 0;
            for (int j = i; j < n; j++) {
                if (s.charAt(j) == c) {flag1=true;break;}
                dis++;
            }
            for (int z = i; z >= 0; z--) {
                if (s.charAt(z) == c) {flag2=true;break;}
                dis2++;
            }
            if (flag1&&flag2){
                answer[i]=Math.min(dis,dis2);
            }else if (!flag1){
                answer[i]=dis2;
            }else {
                answer[i]=dis;
            }

        }
        return answer;
    }
}
