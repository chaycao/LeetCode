import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by chayc on 2017/9/13.
 * 2ms
 * 这个做法利用NULL做隔断。每一层结束，在后面加个NULL
 * 当检测到这个NULL时，就说明已有第n层结束了，而且这n+1层已经都在队列里了
 * 把第n层的list加到resultList里，然后队列里再加一个NULL
 */
public class Solution_1 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resultList = new ArrayList<List<Integer>>();
        if(root == null)
            return resultList;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        queue.add(null);
        List<Integer> list = new ArrayList<Integer>();
        while (queue.size() != 0) {
            TreeNode x = queue.remove();
            if (x == null) {
                resultList.add(list);
                list = new ArrayList<Integer>();
                if (queue.size() > 0)
                    queue.add(null);
            } else {
                list.add(x.val);
                if (x.left != null) queue.add(x.left);
                if (x.right != null) queue.add(x.right);
            }

        }
        return resultList;
    }
}
