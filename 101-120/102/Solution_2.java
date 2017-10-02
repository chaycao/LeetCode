import java.util.ArrayList;
import java.util.List;

/**
 * Created by chayc on 2017/9/13.
 * 1ms
 * 不一层一层的往result里放。
 * 而是遇到相应的一层，就把result里的相应list取出，加进去
 */
public class Solution_2 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        levelOrder(result, root, 0);
        return result;
    }

    private void levelOrder(List<List<Integer>> result, TreeNode root, int level) {
        if (root == null) return;
        if (result.size() <= level) result.add(new ArrayList<>());
        result.get(level).add(root.val);
        levelOrder(result, root.left, level+1);
        levelOrder(result, root.right, level+1);
    }
}
