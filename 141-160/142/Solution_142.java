import java.util.ArrayList;
import java.util.List;

/**
 * Created by chayc on 2017/10/9.
 */
public class Solution_142 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next ==null)
            return;
        ListNode p1 = head;
        ListNode p2 = head;
        while (p2.next != null && p2.next.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        ListNode head2 = p1;
        p2 = head2.next;
        while (p2.next != null) {
            ListNode current = p2.next;
            p2.next = current.next;
            current.next = head2.next;
            head2.next = current;
        }
        p1 = head;
        p2 = head2.next;
        while (p1 != head2) {
            head2.next = p2.next;
            p2.next = p1.next;
            p1.next = p2;
            p1 = p2.next;
            p2 = head2.next;
        }
    }
}
