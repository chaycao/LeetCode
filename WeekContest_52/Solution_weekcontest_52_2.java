/**
 * Created by chayc on 2017/10/1.
 */
public class Solution_weekcontest_52_2 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    private int max = 1;
    public int longestUnivaluePath(TreeNode root) {
        if (root == null)
            return 0;
        dfs(root);
        return max - 1;
    }
    public int dfs(TreeNode root) {
        int val = root.val;
        int len = 1;
        int len_left = 0;
        int len_right = 0;
        if (root.left!=null) {
            if (root.left.val == val)
                len_left = dfs(root.left);
            else
                dfs(root.left);
        }
        if (root.right!=null) {
            if (root.right.val == val)
                len_right += dfs(root.right);
            else
                dfs(root.right);
        }
        len += len_left;
        len += len_right;
        if (len > max)
            max = len;
        return Math.max(len_left,len_right)+1;
    }
}
