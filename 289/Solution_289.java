import java.util.ArrayList;
import java.util.List;

/**
 * @author chaycao
 * @description
 * @date 2018-05-15 18:33.
 */
public class Solution_289 {

    public static void main(String[] args) {
        int[][] board = {{1,1}, {1,0}};
        gameOfLife(board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++)
                System.out.print(board[i][j]+" ");
            System.out.println();
        }
    }

    public static void gameOfLife(int[][] board) {
        if (board == null || board.length == 0)
            return;
        int n = board.length;
        int m = board[0].length;
        List<Integer> dead = new ArrayList<>();
        List<Integer> live = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 0) {
                    if (willLive(board, i, j))
                        live.add(i*m+j);
                } else {
                    if (willDead(board, i, j))
                        dead.add(i*m+j);
                }
            }
        }
        for (int x : dead) {
            board[x/m][x%m] = 0;
        }
        for (int x : live) {
            board[x/m][x%m] = 1;
        }
    }

    public static int NeighborNum(int[][] board, int i, int j) {
        int count = 0;
        int n = board.length;
        int m = board[0].length;
        if ((i-1) >= 0 && (j-1) >= 0 && board[i-1][j-1] == 1)
            count++;
        if ((i-1) >= 0 && board[i-1][j] == 1)
            count++;
        if ((i-1) >= 0 && (j+1) < m && board[i-1][j+1] == 1)
            count++;
        if ((j-1) >= 0 && board[i][j-1] == 1)
            count++;
        if ((j+1) < m && board[i][j+1] == 1)
            count++;
        if ((i+1) < n && (j-1) >= 0 && board[i+1][j-1] == 1)
            count++;
        if ((i+1) < n && j >= 0 && board[i+1][j] == 1)
            count++;
        if ((i+1) < n && (j+1) < m && board[i+1][j+1] == 1)
            count++;
        return count;
    }

    // 细胞状态为1
    public static boolean willDead(int[][] board, int i, int j) {
        int count = NeighborNum(board, i, j);
        if (count < 2) {
            return true;
        } else if (count < 4) {
            return false;
        } else
            return true;
    }

    // 细胞状态为0
    public static boolean willLive(int[][] board, int i, int j) {
        int count = NeighborNum(board, i, j);
        if (count == 3)
            return true;
        return false;
    }
}
