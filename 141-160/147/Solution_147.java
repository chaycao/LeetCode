/**
 * Created by chayc on 2017/10/13.
 */
public class Solution_147 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode insertionSortList(ListNode head) {
        if (head == null)
            return null;
        ListNode p = head.next;
        ListNode q = head;
        ListNode pre_q = head;
        ListNode pre_p = head;
        while (p != null) {
            q = head;
            pre_q = head;
            System.out.println(p.val+" "+pre_p.val);
            // 判断q节点和p节点的大小，若q节点大于p节点，则q继续往下
            int flag = 1;
            while (q!=p && q.val < p.val) {
                q = q.next;
                if (flag == 1) {
                    flag = 0;
                    continue;
                }
                pre_q = pre_q.next;
            }
            if (q != p) { //把p节点插入到pre节点的后面
                if (q == head) {//插入到头结点
                    pre_p.next = p.next;
                    p.next = head;
                    head = p;
                } else {//插入到中间节点
                    pre_p.next = p.next;
                    p.next = q;
                    pre_q.next = p;
                }
                p = pre_p.next;
            } else {
                p = p.next;
                pre_p = pre_p.next;
            }
            ListNode x = head;
            while (x != null) {
                System.out.print(x.val +",");
                x = x.next;
            }
            System.out.println();
        }
        return head;
    }
}
