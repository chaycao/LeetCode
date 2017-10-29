/**
 * Created by chaycao on 2017/10/29.
 * chaycao@163.com
 */
public class Solution_weekcontest_56_3 {
    public int findLength(int[] A, int[] B) {
        int n = A.length;
        int m = B.length;
        int[][] temp = new int[n+1][m+1];
        for (int i = 0; i < n+1; i++) {
            temp[i][0] = 0;
        }
        for (int i = 0; i < m+1; i++) {
            temp[0][i] = 0;
        }
        int result = 0;
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                if (A[i-1] == B[j-1]) {
                    temp[i][j] = temp[i-1][j-1] + 1;
                    if (temp[i][j] > result)
                        result = temp[i][j];
                } else {
                    temp[i][j] = 0;
                }
            }
        }
        return result;
    }
}
