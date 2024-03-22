package hard;

import java.util.ArrayList;
import java.util.List;

public class solveNQueens {
    int[][] directions;
    int len;
    List<List<String>> ans;
    public List<List<String>> solveNQueens(int n) {
        len = n;
        ans = new ArrayList<>();
        //左上，右上，左下，右下
        directions = new int[][]{{-1,-1},{-1,1},{1,-1},{1,1}};
        boolean[][] flag = new boolean[n][n];

        find(flag,0,0,0);

        return ans;

    }

    void find(boolean[][] flag,int row,int column,int curQ){
        if(curQ == len){
            List<String> temp = new ArrayList<>();
            for(int i = 0;i<len;i++){
                StringBuilder sb = new StringBuilder();
                for(int j = 0;j<len;j++){
                    if(flag[i][j]) {
                        sb.append("Q");
                    }else {
                        sb.append(".");
                    }
                }
                temp.add(sb.toString());
            }

            ans.add(temp);
            return;
        }

        if(column == len){
            ++row;
            column = 0;
        }
        if(row>=len){
            return;
        }

        if(isRowAndColValid(flag,row,column)
                &&isCrossLineValid(flag,row,column)){
            //放皇后
            flag[row][column] = true;
            find(flag,row,column+1,curQ+1);
            flag[row][column] = false;

            //不放皇后
            find(flag,row,column+1,curQ);

        }else{
            find(flag,row,column+1,curQ);
        }
    }


    boolean isRowAndColValid(boolean[][] flag,int row,int column){
        for(int i = 0;i<len;i++){
            if(i == column) continue;

            if(flag[row][i]) return false;
        }

        for(int i = 0;i<len;i++){
            if(i == row) continue;

            if(flag[i][column]) return false;
        }

        return true;
    }

    boolean isCrossLineValid(boolean[][] flag,int row,int column){
        for(int[] direction:directions){
            int curRow = row,curCol = column;
            while (curRow>=0&&curRow<len&&curCol>=0&&curCol<len){

                if(flag[curRow][curCol]){
                    return false;
                }
                curRow += direction[0];
                curCol += direction[1];

            }
        }
        return true;

    }
}
