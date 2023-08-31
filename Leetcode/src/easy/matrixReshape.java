package easy;

public class matrixReshape {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int row=mat.length,col=mat[0].length;
        int cntr=0,cntc=0;
        if (r*c!=row*col)return mat;
        int[][] ans=new int[r][c];
        for (int i=0;i<row;i++){
            for (int j=0;j<col;j++){
                if (cntc<c){
                    ans[cntr][cntc++]=mat[i][j];
                }else {
                    cntr++;
                    cntc=0;
                }
            }
        }
        return ans;
    }
}
