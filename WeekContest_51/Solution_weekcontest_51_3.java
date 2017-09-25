import java.util.ArrayList;
import java.util.List;

/**
 * Created by chayc on 2017/9/24.
 * 1. 不能连已有父节点的节点
 * 2. 不能把自己的父节点作为子节点
 */
public class Solution_weekcontest_51_3 {
    public int[] findRedundantConnection(int[][] edges) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < 2000; i++)
            list.add(new ArrayList<>());
        int[] result = new int[2];
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            if (helper(list, u, u, v) == true)
                result = edges[i];
            else {
                list.get(u).add(v);
                list.get(v).add(u);
            }
        }

        return result;
    }

    public boolean helper(List<List<Integer>> list, int n, int par, int target) {
        List<Integer> list_n = list.get(n);
        for (int i = 0; i < list_n.size(); i++) {
            int x = list_n.get(i);
            if (x == par)
                continue;
            if (x == target)
                return true;
            if (helper(list, x, n, target) == true)
                return true;
        }
        return false;
    }
}
