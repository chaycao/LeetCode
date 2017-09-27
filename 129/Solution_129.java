import java.util.ArrayList;
import java.util.List;

/**
 * Created by chayc on 2017/9/27.
 */
public class Solution_129 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public int sumNumbers(TreeNode root) {
        if (root == null)
            return 0;

        return dfs(root, 0);
    }

    public int dfs(TreeNode root, int sum) {
        sum = sum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        }
        return (root.left != null?dfs(root.left, sum):0) + (root.right != null?dfs(root.right, sum):0);
    }
}
