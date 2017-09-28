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
        Queue<Integer> queue_x = new LinkedList<>();
        Queue<Integer> queue_y =  new LinkedList<>();
        queue_x.offer(x);
        queue_y.offer(y);
        while (queue_x.size() != 0) {
            int a = queue_x.poll();
            int b = queue_y.poll();
            board[a][b] = '$';
            for (int i = 0; i < 4; i++) {
                int dx = x + dir[i][0];
                int dy = y + dir[i][1];
                if (dx >= 0 && dx < height && dy >= 0 && dy < width && board[dx][dy] == 'O') {
                    queue_x.offer(dx);
                    queue_y.offer(dy);
                }
            }
        }
    }
}
