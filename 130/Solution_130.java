import javafx.util.Pair;

import java.util.*;

/**
 * Created by chayc on 2017/9/28.
 */
public class Solution_130 {
    private int[][] dir = {{1, 0},{0, 1},{-1, 0},{0, -1}};
    private int height = 0;
    private int width = 0;
    public void solve(char[][] board) {
        height = board.length;
        if (height <= 0)
            return;
        width = board[0].length;

        for (int i = 0; i < width; i++) {
            if (board[0][i] == 'O') dfs(board, 0, i);
            if (board[height-1][i] == 'O') dfs(board, height-1, i);
        }
        for (int i = 1; i < height-1; i++) {
            if (board[i][0] == 'O') dfs(board, i, 0);
            if (board[i][width-1] == 'O') dfs(board, i, width-1);
        }
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (board[i][j] == '$') board[i][j] = 'O';
                else if (board[i][j] == 'O') board[i][j] = 'X';
            }
        }
    }
    public void dfs (char[][] board, int x, int y) {
        Stack<Integer> stack_x = new Stack<>();
        Stack<Integer> stack_y =  new Stack<>();
        stack_x.push(x);
        stack_y.push(y);
        board[x][y] = '$';
        while (stack_x.size() != 0) {
            int a = stack_x.pop();
            int b = stack_y.pop();
            for (int i = 0; i < 4; i++) {
                int dx = a + dir[i][0];
                int dy = b + dir[i][1];
                if (dx >= 0 && dx < height && dy >= 0 && dy < width && board[dx][dy] == 'O') {
                    stack_x.push(dx);
                    stack_y.push(dy);

                    board[dx][dy] = '$';
                }
            }
        }
    }
}
