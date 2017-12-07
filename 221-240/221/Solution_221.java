/**
 * Created by chaycao on 2017/12/6.
 * chaycao@163.com
 */
public class Solution_221 {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int result = 0;
        int[][] flag = new int[n][m];
        for (int i = 0; i < n; i++) {
            if (matrix[i][0] == '0')
                flag[i][0] = 0;
            else {
                flag[i][0] = 1;
                result = 1;
            }
        }
        for (int i = 1; i < m; i++) {
            if (matrix[0][i] == '0')
                flag[0][i] = 0;
            else {
                flag[0][i] = 1;
                result = 1;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] == '0') {
                    flag[i][j] = 0;
                    continue;
                }
                flag[i][j] = Math.min(Math.min(flag[i][j-1], flag[i-1][j]), flag[i-1][j-1]) + 1;
                result = Math.max(flag[i][j]*flag[i][j], result);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        return result;
    }
}
