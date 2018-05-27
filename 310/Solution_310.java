import java.util.*;

/**
 * @author chaycao
 * @description
 * @date 2018-05-27 23:05.
 */
public class Solution_310 {
    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if (n == 0 || edges.length == 0)
        {
            res.add(0);
            return res;
        }
        List<Set<Integer>> adj = new ArrayList<>(n);
        for (int i = 0; i < n; i++)
            adj.add(new HashSet<>());
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (adj.get(i).size() == 1)
            {
                leaves.add(i);
            }
        }
        while (n > 2) {
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for (int leaf : leaves) {
                Set<Integer> set = adj.get(leaf);
                for (int x : set) {
                    adj.get(x).remove(leaf);
                    if (adj.get(x).size() == 1)
                        newLeaves.add(x);
                }
            }
            leaves = newLeaves;
        }
        return leaves;
    }

    public static void main(String[] args) {
        int n = 1;
        int[][] graph = {
        };
        List<Integer> res = findMinHeightTrees(n, graph);
        for (int i : res) {
            System.out.println(i);
        }
    }
}
