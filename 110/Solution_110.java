/**
 * Created by chayc on 2017/9/19.
 * 每个节点比较左右的深度
 * 节点将左右深度的最大值，往上传给父节点，父节点在该值基础上加1
 */
public class Solution_110 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        int[] depth = new int[1];
        return fun(root, depth);
    }

    public boolean fun(TreeNode root, int[] depth) {
        if (root.left == null && root.right == null) {
            depth[0] = 0;
            return true;
        }
        int d_left = 0, d_right = 0;
        if (root.left != null) {
            if(fun(root.left, depth) == false)
                return false;
            d_left = ++depth[0];
        }
        if (root.right != null) {
            if(fun(root.right, depth) == false)
                return false;
            d_right = ++depth[0];
        }
        System.out.println("" + root.val + " " + d_left + " " +d_right);
        depth[0] = Math.max(d_left, d_right);
        if (Math.abs(d_left - d_right) <= 1)
            return true;
        else
            return false;
    }
}
