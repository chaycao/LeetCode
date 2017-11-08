/**
 * Created by chaycao on 2017/11/8.
 * chaycao@163.com
 */
public class Solution_72 {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] flag = new int[n+1][m+1];
        for (int i = 1; i < n+1; i++)
            flag[i][0] = i;
        for (int i = 1; i < m+1; i++)
            flag[0][i] = i;
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < n+1; j++) {
                ;
            }
        }
        return Math.max(n, m) - flag[n][m];
    }
}
