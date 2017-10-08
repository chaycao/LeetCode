/**
 * Created by chayc on 2017/10/8.
 */
public class Solution_weekcontest_53_2 {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null)
            return 0;
        int height = grid.length;
        int width = grid[0].length;
        int par[] = new int[height*width];
        int temp[] = new int[height*width];
        for (int i = 0; i < height*width; i++) {
            par[i] = i;
        }
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (grid[i][j] != 1)
                    continue;
                if (i!=0) {
                    if (grid[i-1][j] == 1) {
                        unionSet(i*width+j, (i-1)*width+j, par);
                    }
                }
                if (j!=0) {
                    if (grid[i][j-1] == 1) {
                        unionSet(i*width+j, i*width+j-1, par);
                    }
                }
            }
        }
        int max = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (grid[i][j] == 0)
                    continue;
                int n = find(i*width+j, par);
                temp[n]++;
                if (max<temp[n])
                    max = temp[n];
            }
        }
        return max;
    }
    public int find(int n, int par[]) {
        if (n!=par[n]) par[n] = find(par[n], par);
        return par[n];
    }
    public void unionSet(int x, int y, int par[]) {
        if ((x=find(x,par)) == (y=find(y,par)))
            return;
        par[x] = y;
    }
}
