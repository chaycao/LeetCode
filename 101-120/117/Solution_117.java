import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by chayc on 2017/9/21.
 * 加null进行隔断，也可以一开始获取队列的长度，知道每一层的长度
 */
public class Solution_117 {
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
        queue.offer(root);
        queue.offer(null);
        while (true) {
            TreeLinkNode node = queue.poll();
            if (node == null)
                return;
            TreeLinkNode next = queue.peek();
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
            if (next != null) {
                node.next = next;
            } else {
                node.next = null;
                queue.poll();
                queue.offer(null);
            }
        }
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(null);
        System.out.println(queue.size());
        System.out.println(queue.poll());
        System.out.println(queue.size());
    }
}
