/**
 * Title:
 *
 * @author chaycao
 * @description:
 * @date 2018-01-03 09:59.
 */
public class Solution_236 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    TreeNode result;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        visit(root, 0, p, q);
        return result;
    }

    public int visit(TreeNode root, int k, TreeNode p, TreeNode q) {
        if (root == null)
            return k;
        int a = visit(root.left, k, p, q);
        int b = visit(root.right, k, p, q);
        if (a < 0 || b < 0)
            return -1;
        k = a + b;
        if (k == 1) {
            if (root == p || root == q) {
                result = root;
                k = -1; // 已经找到
            }
        }
        if (k == 2) {
            result = root;
            k = -1;
        }
        if (root == p || root == q)
            k++;
        return k;
    }
}
