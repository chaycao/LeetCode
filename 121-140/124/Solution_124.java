/**
 * Created by chayc on 2017/9/24.
 */
public class Solution_124 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    private int max = Integer.MIN_VALUE;
    private int max_temp = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {

       helpSum(root);

        return max;

    }

    public void helpSum (TreeNode root) {
        if(root == null)
            return;
        helpSum(root.left);
        helpSum(root.right);
        int left = 0, right = 0;
        if (root.left != null)
            left = root.left.val;
        if (root.right != null)
            right = root.right.val;
        int result = root.val;
        if (left > 0) result += root.left.val;
        if (right > 0) result += root.right.val;
        if (max < result) max = result;

        left += root.val;
        right += root.val;
        if (root.val < left) root.val = left;
        if (root.val < right) root.val = right;
    }


}
