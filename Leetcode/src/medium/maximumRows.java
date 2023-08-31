package medium;

public class maximumRows {
    int[][] m;
    int max=0;
    public int maximumRows(int[][] matrix, int numSelect) {
        if (matrix[0].length==1) return matrix.length;
        m=matrix;
        dfs(0,numSelect);
        return max;
    }
    void dfs(int ind,int num){
        if (num==0) {
            int sum=0;
            for (int[] row:m){
                sum++;
                for (int n:row){
                    if (n==1) {
                        sum--;
                        break;
                    }
                }
            }
            max=Math.max(sum,max);
            return ;
        }
        for (int j=ind+1;j<m[0].length;j++) {
            int[] save=new int[m.length];
            for (int i = 0; i < m.length; i++) {
                save[i]=m[i][j];
                if (m[i][j] == 1) m[i][j] = 0;
            }

            dfs(j,--num);
            for (int k=0;k<save.length;k++) m[k][j]=save[k];
        }
    }

}
