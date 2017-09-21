import java.util.Stack;

/**
 * Created by chayc on 2017/9/21.
 */
public class Solution_98 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        return dfs(root, Long.MIN_VALUE, (long)root.val, (long)root.val, Long.MAX_VALUE);
    }
    public boolean dfs(TreeNode root, long min_l, long max_l, long min_r, long max_r){
        if (root.left != null) {
            if ((long)root.left.val >= max_l || (long)root.left.val <= min_l) {
                    return false;
            } else {
                if (dfs(root.left, (long)min_l, (long)root.left.val, (long)root.left.val, (long)max_l) == false)
                    return false;
            }
        }
        if (root.right != null) {
            if((long)root.right.val >= max_r || (long)root.right.val <= min_r) {
                    return false;
            } else {
                if (dfs(root.right, (long)min_r, (long)root.right.val, (long)root.right.val, (long)max_r) == false)
                    return false;
            }
        }
        return true;
    }

}
