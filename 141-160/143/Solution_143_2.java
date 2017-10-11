import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by chayc on 2017/10/10.
 * 迭代的方法
 */
public class Solution_143_2 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    List<Integer> result = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            if (node == null)
                continue;
            result.add(node.val);
            stack.push(node.right);
            stack.push(node.left);
        }
        return result;
    }
}
