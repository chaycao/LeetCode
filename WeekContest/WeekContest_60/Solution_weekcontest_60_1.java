/**
 * Created by chaycao on 2017/11/26.
 * chaycao@163.com
 */
public class Solution_weekcontest_60_1 {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image.length == 0 || sr > image.length || sc > image[0].length)
            return image;
        int[][] flag = new int[image.length][image[0].length];
        dfs(sr, sc, image.length, image[0].length, image, newColor, image[sr][sc], flag);
        return image;
    }

    public void dfs(int i, int j, int n, int m, int[][] image, int newColor, int oldColor, int[][] flag) {
        image[i][j] = newColor;
        flag[i][j] = 1;
        if (i+1 < n && flag[i+1][j] != 1 && image[i+1][j] == oldColor)
            dfs(i+1, j, n, m, image, newColor, oldColor, flag);
        if (i-1 >= 0 && flag[i-1][j] != 1 && image[i-1][j] == oldColor)
            dfs(i-1, j, n, m, image, newColor, oldColor, flag);
        if (j+1 < m && flag[i][j+1] != 1 && image[i][j+1] == oldColor)
            dfs(i, j+1, n, m, image, newColor, oldColor, flag);
        if (j-1 >= 0 && flag[i][j-1] != 1 && image[i][j-1] == oldColor)
            dfs(i, j-1, n, m, image, newColor, oldColor, flag);
    }
}
