/**
 * Created by chayc on 2017/10/13.
 */
public class Solution_147_2 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode NullHead = new ListNode(0);
        NullHead.next = head;
        ListNode q = NullHead;
        ListNode p = head;
        while (p.next!=null) { //把q和p的next做比较
            q = NullHead;
            while (q!=p && q.next.val < p.next.val) {
                q = q.next;
            }
            if (q==p) {
                p = p.next;
            } else {
                ListNode temp = p.next;
                p.next = temp.next;
                temp.next = q.next;
                q.next = temp;
            }
        }
        return NullHead.next;
    }
}
