package easy;

public class findJudge {
    public int findJudge(int n, int[][] trust) {
        int[] people = new int[n];
        for (int[] person : trust) {
            people[person[0]-1]-=1;
            people[person[1]-1]+=1;
        }
        for (int i = 0; i < n; i++) {
            if (people[i]==n-1) return i;
        }
        return -1;
    }
}
