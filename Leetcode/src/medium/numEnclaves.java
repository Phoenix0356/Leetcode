package medium;

public class numEnclaves {
    int ans=1;
    public int numEnclaves(int[][] grid) {
        int res = 0;
        int temp = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    temp++;
                }
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1 && (i == 0 || i == grid.length - 1 || j == 0 || j == grid[0].length - 1)) {
                        res += isLand(i, j, grid);
                        ans=1;
                    }
                }
            }
            if (res == 0) return temp;
            return temp - res;
        }

    int isLand(int rowi,int coli,int[][] grid){
        grid[rowi][coli]=0;
        for (int[] step:dic){
            if (0<=rowi+step[0]&&rowi+step[0]<grid.length&&coli+step[1]>=0&&coli+step[1]<grid[0].length){
                if (grid[rowi+step[0]][coli+step[1]]==1) {
                    grid[rowi + step[0]][coli + step[1]]=0;
                    ans=isLand(rowi + step[0], coli + step[1], grid);
                    ans++;
                }

            }
        }
        return ans;
    }
    final int[][] dic={{1,0},{-1,0},{0,1},{0,-1}};
}
