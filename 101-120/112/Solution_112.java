/**
 * Created by chayc on 2017/9/20.
 */
public class Solution_112 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;
        return dfs(root, 0, sum);
    }

    public boolean dfs(TreeNode root, int sum, int target) {
        if (root.left == null && root.right == null) {
            if (sum + root.val == target)
                return true;
        }
        if (root.left != null) {
            if (dfs(root.left, sum + root.val, target) == true)
                return true;
        }
        if (root.right != null) {
            if (dfs(root.right, sum + root.val, target) == true)
                return true;
        }
        return false;
    }
}
