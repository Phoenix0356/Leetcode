package medium;

public class countServers {
    public int countServers(int[][] grid) {
        int count=0;
        for (int i=0;i<grid.length;i++){
            for (int j=0;j< grid[0].length;j++){
                boolean isFind=false;
                if (grid[i][j]==1){
                    for (int row=0;row< grid.length;row++){
                        if (row==i) continue;
                        if (grid[row][j]==1) {
                            count++;
                            isFind=true;
                            break ;
                        }
                    }
                    if (!isFind) {
                        for (int col = 0; col < grid[0].length; col++) {
                            if (col == j) continue;
                            if (grid[i][col] == 1) {
                                count++;
                                break;
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}
