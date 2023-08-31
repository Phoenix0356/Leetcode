package medium;

import java.util.Arrays;
import java.util.Comparator;

public class sortTheStudents {
    public int[][] sortTheStudents(int[][] score, int k) {
        Arrays.sort(score, Comparator.comparingInt(o -> o[k]));
        return  score;
    }
}
