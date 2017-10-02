/**
 * Created by chayc on 2017/9/16.
 * dfs,函数返回深度
 */
public class Solution_104 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public int maxDepth(TreeNode root) {
        int max = 0;
        if (root == null)
            return max;
        return dfs(root,1, max);
    }
    public int dfs(TreeNode root, int depth, int max) {
        if (max < depth)
            max = depth;
        System.out.println(root.val);
        if (root.left != null) {
            int temp = dfs(root.left, depth+1, max);
            if (max < temp) {
                max = temp;
            }
        }
        if (root.right != null) {
            int temp = dfs(root.right, depth+1, max);
            if (max < temp) {
                max = temp;
            }
        }
        return max;
    }
}
