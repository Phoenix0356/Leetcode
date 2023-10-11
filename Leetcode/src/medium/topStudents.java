package medium;

import java.util.*;

public class topStudents {
    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        HashSet<String> setN = new HashSet<>(Arrays.asList(negative_feedback));
        HashSet<String> setP = new HashSet<>(Arrays.asList(positive_feedback));
        List<Integer> list=new ArrayList<>();
        int[][] points=new int[student_id.length][2];
        for (int i=0;i< report.length;i++){
            String[] words=report[i].split(" ");
            int point=0;
            for (String word:words){
                if (setP.contains(word)) point+=3;
                else if (setN.contains(word)) point--;
            }
            points[i][0]=student_id[i];
            points[i][1]=point;
        }
        Arrays.sort(points, (o1, o2) -> {
            if (o1[1]==o2[1]) return o1[0]-o2[0];
            return o2[1]-o1[1];
        });
        for (int i=0;i<k;i++) list.add(points[i][0]);
        return list;
    }
}
