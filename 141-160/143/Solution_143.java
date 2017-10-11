import java.util.ArrayList;
import java.util.List;

/**
 * Created by chayc on 2017/10/10.
 * 递归的方法
 */
public class Solution_143 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    List<Integer> result = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        helper(root);
        return result;
    }
    public void helper(TreeNode root) {
        if (root == null)
            return;
        result.add(root.val);
        helper(root.left);
        helper(root.right);
    }
}
