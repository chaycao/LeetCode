/**
 * Created by chaycao on 2017/10/24.
 * chaycao@163.com
 */
public class Solution_160 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
          val = x;
          next = null;
        }
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA==null || headB==null) return null;
        int len_a = len(headA);
        int len_b = len(headB);
        while (len_a > len_b) {
            headA = headA.next;
            len_a--;
        }
        while (len_b > len_a) {
            headB = headB.next;
            len_b--;
        }
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
    public int len(ListNode head) {
        int len = 0;
        while (head!=null) {
            head = head.next;
            len++;
        }
        return len;
    }
}
