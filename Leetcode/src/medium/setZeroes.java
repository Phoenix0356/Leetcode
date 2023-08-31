package medium;

public class setZeroes {
    public void setZeroes(int[][] matrix) {
        boolean[][] arr=new boolean[matrix.length][matrix[0].length];
        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[0].length;j++){
                if (matrix[i][j]==0){
                    arr[i][j]=true;
                }
            }
        }
        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[0].length;j++) {
                    if (arr[i][j]==true){
                        setM(i,j,matrix);
                    }
                }
            }
    }
    void setM(int r,int c,int[][] m){
        for (int i=0;i<m[0].length;i++){
            m[r][i]=0;
        }
        for (int i=0;i<m.length;i++){
            m[i][c]=0;
        }
    }
}
