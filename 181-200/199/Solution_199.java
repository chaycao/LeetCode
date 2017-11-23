import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by chaycao on 2017/11/23.
 * chaycao@163.com
 */
public class Solution_199 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null)
            return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        while (true) {
            TreeNode node = queue.poll();
            if (node == null) {
                if (queue.peek() == null)
                    return list;
                queue.offer(null);
                continue;
            }

            if (queue.peek() == null) {
                list.add(node.val);
            }
            if (node.left != null)
                queue.offer(node.left);
            if (node.right != null)
                queue.offer(node.right);
        }
    }
}
