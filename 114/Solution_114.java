/**
 * Created by chayc on 2017/9/19.
 * 1ms,递归
 */
public class Solution_114 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public void flatten(TreeNode root) {
        if (root==null)
            return;
        fun(root);
    }

    public TreeNode fun(TreeNode root) {
        if (root.left == null && root.right == null)
            return root;

        if (root.left != null) {
            if (root.right != null) {
                TreeNode n = fun(root.left);
                fun(root.right);
                n.right = root.right;
                root.right = root.left;
                root.left = null;
            } else {
                fun(root.left);
                root.right = root.left;
                root.left = null;
            }
        } else {
            fun(root.right);
        }
        while (root.right != null) {
            root = root.right;
        }
        return root;
    }
}
