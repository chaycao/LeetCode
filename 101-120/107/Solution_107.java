import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by chayc on 2017/9/16.
 */
public class Solution_107 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        dfs(root, 1, result);
        Collections.reverse(result);
        return result;
    }

    public void dfs(TreeNode root, int index, List<List<Integer>> result) {
        if (index > result.size())
            result.add(new ArrayList<>());
        result.get(index-1).add(root.val);
        if (root.left != null)
            dfs(root.left,index+1, result);
        if (root.right != null)
            dfs(root.right,index+1, result);
    }
}
