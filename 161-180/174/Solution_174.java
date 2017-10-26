/**
 * Created by chaycao on 2017/10/26.
 * chaycao@163.com
 */
public class Solution_174 {
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null)
            return 0;
        int n = dungeon.length;
        int m = dungeon[0].length;
        int temp[][] = new int[n][m];
        temp[n-1][m-1] = Math.max(1 - dungeon[n-1][m-1], 1);
        for (int i = n-2; i >=0; i--) {
            temp[i][m-1] = Math.max(temp[i+1][m-1] - dungeon[i][m-1], 1);
        }
        for (int j = m-2; j >= 0; j--) {
            temp[n-1][j] = Math.max(temp[n-1][j+1] - dungeon[n-1][j], 1);
        }

        for (int i = n-2; i >= 0; i--) {
            for (int j = m-2; j >= 0 ; j--) {
                int down = Math.max(temp[i+1][j] - dungeon[i][j], 1);
                int up = Math.max(temp[i][j+1] - dungeon[i][j], 1);
                temp[i][j] = Math.min(down, up);
            }
        }
        return temp[0][0];

    }
}
