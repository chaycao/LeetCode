/**
 * Created by chayc on 2017/9/20.
 * dfs
 */
public class Solution_111 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    private int min_depth = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        dfs(root, 0);
        return min_depth;
    }

    public void dfs(TreeNode root, int index) {
        if (root.left == null && root.right == null) {
            min_depth = Math.min(min_depth, index);
            return;
        }
        if (root.left != null) dfs(root.left, index + 1);
        if (root.right != null) dfs(root.right, index + 1);
    }
}
