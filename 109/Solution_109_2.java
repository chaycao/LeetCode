/**
 * Created by chayc on 2017/9/17.
 */
public class Solution_109_2 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;
        return fun(head, null);
    }
    public TreeNode fun(ListNode head, ListNode tail) {
        ListNode slow = head, fast = head;
        if (head == tail)
            return null;
        while (fast.next != tail && fast.next.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = fun(head, slow);
        root.right = fun(slow.next, tail);
        return root;
    }
}
