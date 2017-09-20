import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by chayc on 2017/9/20.
 * bfs n为每层的数量，i表示该层的第几个。层的末尾时，连接null
 */
public class Solution_116 {
    public class TreeLinkNode {
        int val;
        TreeLinkNode left, next;
        TreeLinkNode right;
        TreeLinkNode(int x) { val = x; }
    }
    public void connect(TreeLinkNode root) {
        if (root == null)
            return;
        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.add(root);
        bfs(queue, 1, 1);
    }
    public void bfs (Queue<TreeLinkNode> queue, int n, int i) {
        if (queue.isEmpty() == true)
            return;
        TreeLinkNode node = queue.poll();
        if (i < n) {
            node.next = queue.peek();
        } else {
            node.next = null;
            n *= 2;
            i = 0;
        }
        if (node.left != null) {
            queue.offer(node.left);
            queue.offer(node.right);
        }
        bfs(queue, n, ++i);
    }
}
