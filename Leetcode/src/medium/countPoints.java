package medium;

public class countPoints {
    public int[] countPoints(int[][] points, int[][] queries) {
        int n = queries.length;
        int[] res = new int[n];
        for(int i = 0 ; i < queries.length ; i++){
            for(int j = 0 ; j < points.length ; j++){
                if(Math.sqrt((queries[i][0] - points[j][0])
                        * (queries[i][0] - points[j][0])
                        + (queries[i][1] - points[j][1])
                        * (queries[i][1] - points[j][1])) <= queries[i][2]){
                    res[i]++;
                }
            }
        }
        return res;
    }
}
