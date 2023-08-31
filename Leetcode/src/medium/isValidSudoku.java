package medium;

import java.util.Arrays;

public class isValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        boolean[] n = new boolean[10];
        int cnt = 0, ind = 0, limit = 0;
        for (int i = 0; i < board.length; i++) {
            Arrays.fill(n, false);
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.'&& !n[Character.getNumericValue(board[i][j])]) {
                    n[Character.getNumericValue(board[i][j])] = true;
                }else if (board[i][j] != '.' && n[Character.getNumericValue(board[i][j])]) return false;
            }
        }
        for (int i = 0; i < board.length; i++) {
            Arrays.fill(n, false);
            for (int j = 0; j < board[0].length; j++) {
                if (board[j][i] != '.'&& !n[Character.getNumericValue(board[j][i])]) {
                    n[Character.getNumericValue(board[j][i])] = true;
                }else if (board[j][i] != '.' && n[Character.getNumericValue(board[j][i])]) return false;
            }
        }
        while (cnt < 6){
            while (limit < 6) {
                Arrays.fill(n, false);
                for (int i = cnt; i < cnt + 3; i++) {
                    for (ind=limit; ind < limit+3; ind++) {
                        if (board[i][ind] != '.'&& !n[Character.getNumericValue(board[i][ind])]) {
                            n[Character.getNumericValue(board[i][ind])] = true;
                        }else if (board[i][ind] != '.' && n[Character.getNumericValue(board[i][ind])]) return false;
                    }
                }
                limit += 3;
            }
            cnt+=3;limit=0;
        }
        return true;
    }
}
