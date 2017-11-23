/**
 * Created by chaycao on 2017/11/23.
 * chaycao@163.com
 */
public class Solution_200 {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        if (n == 0)
            return 0;
        int m = grid[0].length;
        int count = 0;
        int[] flag = new int[n*m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                flag[i*m + j] = i * m + j;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] != '1')
                    continue;
                if (i != 0 && grid[i-1][j] == '1') {
                    union((i-1)*m+j, i*m+j, flag);
                }
                if (j != 0 && grid[i][j-1] == '1') {
                    union(i*m+j, i*m+j-1, flag);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] != '1')
                    continue;
                if (flag[i*m+j] == i * m + j)
                    count++;
            }
        }
        return count;
    }

    public int find(int x, int[] flag) {
        if (x != flag[x])
            flag[x] = find(flag[x], flag);
        return flag[x];
    }

    public void union(int x, int y, int[] flag) {
        int fx = find(x, flag), fy = find(y, flag);
        if (fx != fy)
            flag[fx] = fy;
    }
}
