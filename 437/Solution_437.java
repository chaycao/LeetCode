import java.util.ArrayList;
import java.util.List;

/**
 * @author chaycao
 * @description
 * @date 2018-06-13 22:21.
 */
public class Solution_437 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private int count = 0;
    private List<TreeNode> list = new ArrayList<>();
    public int pathSum(TreeNode root, int sum) {
        collect(root);
        for (TreeNode node : list) {
            dfs(node, 0, sum);
        }
        return count;
    }

    public void collect(TreeNode root) {
        if (root != null)
            list.add(root);
        collect(root.left);
        collect(root.right);
    }

    public void dfs(TreeNode root, int sum, int target) {
        if (root == null)
            return;
        if (target == sum+root.val) {
            count++;
        }
        dfs(root.left, sum+root.val, target);
        dfs(root.right, sum+root.val, target);
    }
}
