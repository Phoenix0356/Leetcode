package easy;

public class checkXMatrix {
    public boolean checkXMatrix(int[][] grid) {
        for (int i=0;i<grid.length;i++){
            if (grid[i][i] == 0 || grid[i][grid[0].length - 1 - i] == 0) {
                return false;
            }
            for (int j=0;j<grid[0].length;j++){
                if (i!=j&&(grid[0].length - 1 - i)!=j) {
                    if (grid[i][j] != 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}