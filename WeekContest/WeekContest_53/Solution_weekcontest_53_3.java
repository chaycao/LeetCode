import java.util.*;

/**
 * Created by chayc on 2017/10/8.
 */
public class Solution_weekcontest_53_3 {
    public int numDistinctIslands(int[][] grid) {
        if (grid == null)
            return 0;
        int height = grid.length;
        int width = grid[0].length;
        int par[] = new int[height*width];
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
        List<List<Integer>> list = new ArrayList<>();
        int index = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (grid[i][j] == 0)
                    continue;
                int n = find(i*width+j, par);
                if (map.containsKey(n)) {
                    int x = map.get(n);
                    list.get(x).add(i*width+j);
                } else {
                    list.add(new ArrayList<>());
                    map.put(n, index);
                    list.get(index).add(i*width+j);
                    index++;
                }
            }
        }
        for (int i = 0; i < list.size(); i++) {
            int start = list.get(i).get(0);
            for (int j = 0; j < list.get(i).size(); j++) {
                int temp = list.get(i).get(j);
                list.get(i).set(j, temp - start);
            }
        }
        Set<List<Integer>> set = new HashSet<>(list);
        System.out.println(set.size());
        return set.size();
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
