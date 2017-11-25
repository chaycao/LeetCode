/**
 * Created by chaycao on 2017/11/25.
 * chaycao@163.com
 */
public class Solution_203 {
    public class ListNode {
        int val;
        ListNode(int x) { val = x; }
        ListNode next;
    }

    public ListNode removeElements(ListNode head, int val) {
        if (head == null)
            return head;
        ListNode slow = head;
        if (slow.next == null) {
            if (slow.val == val)
                return null;
            else
                return head;
        }
        while (slow.val == val) {
            slow = slow.next;
            if (slow == null)
                return null;
        }
        head = slow;
        ListNode fast = slow.next;
        while (fast != null) {
            if (fast.val == val) {
                slow.next = fast.next;
            } else {
                slow = slow.next;
            }
            fast = fast.next;
        }
        return head;
    }
}
