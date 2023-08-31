package easy;

public class imageSmoother {
    public int[][] imageSmoother(int[][] img) {
        int[][] changeDir={{0,0},{1,0},{0,-1},{-1,0},{-1,0},{0,1},{0,1},{1,0},{1,0}};
        int[][] res=new int[img.length][img[0].length];
        int temp=0;
        for (int i=0;i<img.length;i++){
            for (int j=0;j<img[0].length;j++){
                int numRemains=9,row=i,col=j;
                int average=0;
                inner:for (int[] dir:changeDir){
                    col=col+dir[0];
                    row=row+dir[1];
                    if (row<0||row>=img.length||col<0||col>=img[0].length){
                        numRemains--;
                        continue inner;
                    }else {
                        average+=img[row][col];
                    }
                }
                res[i][j]=average/numRemains;
            }
        }
        return res;
    }
}
