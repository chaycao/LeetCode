import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by chayc on 2017/9/18.
 * 5ms,深度搜索
 * 本以为 遍历过程中比sum大，则直接剪枝，没有考虑到负数的情况
 */
public class Solution_113 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;
        Stack<Integer> stack = new Stack<>();
        dfs(root, sum, 0, stack, result);
        return result;
    }

    public void dfs(TreeNode root, int sum, int list_sum, Stack<Integer> stack, List<List<Integer>> result) {
        int n = list_sum + root.val;
        if (root.left == null && root.right == null) {
            if (n == sum) {
                stack.push(root.val);
                result.add(new ArrayList<>(stack));
                stack.pop();
                return;
            }
        }
        if (root.left != null) {
            stack.push(root.val);
            dfs(root.left, sum, n, stack, result);
            stack.pop();
        }
        if (root.right != null) {
            stack.push(root.val);
            dfs(root.right, sum, n, stack, result);
            stack.pop();
        }
    }
}
