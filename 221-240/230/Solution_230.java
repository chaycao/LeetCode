import java.util.Stack;

/**
 * Title:
 *
 * @author chaycao
 * @description:
 * @date 2018-01-02 19:36.
 */
public class Solution_230 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    private int x;
    private int result;

    public int kthSmallest(TreeNode root, int k) {
        x = k;
        visit(root);
        return result;
    }

    public void visit(TreeNode root) {
        if (root == null)
            return;
        visit(root.left);
        x--;
        if (x == 0) {
            result = root.val;
            return;
        }
        if (x < 0) {
            return;
        }
        visit(root.right);
        return;
    }
}
