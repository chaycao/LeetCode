import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by chayc on 2017/10/8.
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
public class Solution_141 {
    public boolean hasCycle(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        if (head == null)
            return false;
        list.add(head);
        while(head.next!=null) {
            if (list.contains(head.next))
                return true;
            list.add(head.next);
            head = head.next;
        }
        return false;
    }
}
