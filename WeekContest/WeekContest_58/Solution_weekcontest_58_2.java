import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by chaycao on 2017/11/12.
 * chaycao@163.com
 */
public class Solution_weekcontest_58_2 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode[] splitListToParts(ListNode root, int k) {
        List<ListNode> result = new ArrayList<>();
        HashMap<Integer, ListNode> map = new HashMap<>();
        int index = 0;
        while (root != null) {
            map.put(index++, root);
            root = root.next;
        }
        if (index <= k) {
            for (int i = 0; i < index; i++) {
                map.get(i).next = null;
                result.add(map.get(i));
            }
            for (int i = 0; i < k-index; i++) {
                result.add(null);
            }
            ListNode[] r = new ListNode[result.size()];
            for (int i = 0; i < result.size(); i++) {
                r[i] = result.get(i);
            }
            return r;
        }
        int p = index/k;
        for (int i = index-1; i>0;) {
            if (i-p <= 0) {
                result.add(0, map.get(0));
                map.get(i).next = null;
                break;
            }
            result.add(0, map.get(i-p+1));
            map.get(i).next = null;
            i -= p ;
        }
        ListNode[] r = new ListNode[result.size()];
        for (int i = 0; i < result.size(); i++) {
            r[i] = result.get(i);
        }
        return r;
    }
}
