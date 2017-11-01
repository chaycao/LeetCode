/**
 * Created by chaycao on 2017/11/1.
 * chaycao@163.com
 */
public class Solution_583 {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        char[] c1 = word1.toCharArray();
        char[] c2 = word2.toCharArray();
        int[][] temp = new int[n+1][m+1];
        for (int i = 0; i < n+1; i++) {
            temp[i][m] = 0;
        }
        for (int j = 0; j < m+1; j++) {
            temp[n][j] = 0;
        }
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                if (c1[i-1] == c2[j-1]) {
                    System.out.println(i+" "+j);
                    temp[i][j] = temp[i-1][j-1] + 1;
                }
                else {
                    temp[i][j] = Math.max(temp[i-1][j], temp[i][j-1]);
                }
            }
        }
        return word1.length() + word2.length() - temp[n][m] * 2;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_583().minDistance("",""));
    }
}
