/**
 * Created by chayc on 2017/10/14.
 */
public class Solution_148 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }
    public ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode pre = null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        // 从slow分开，slow.next为右边段的开始
        ListNode left = head;
        ListNode right = slow;

        left = mergeSort(left);
        right = mergeSort(right);
        return merge(left, right);
    }
    public ListNode merge(ListNode left, ListNode right) {
        ListNode head_L = new ListNode(-1);
        ListNode p = head_L;
        while (left!=null && right!=null) {
            if (left.val < right.val) {
                p.next = left;
                left = left.next;
            } else {
                p.next = right;
                right = right.next;
            }
            p = p.next;
        }
        if (left != null)
            p.next = left;
        if (right != null)
            p.next = right;
        return head_L.next;
    }
}
