import java.util.ArrayList;
import java.util.List;

/**
 * Created by chayc on 2017/10/11.
 */
public class Solution_144 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    List<Integer> result = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        helper(root);
        return result;
    }
    public void helper(TreeNode root) {
        if (root == null)
            return;
        helper(root.left);
        helper(root.right);
        result.add(root.val);
    }
}
