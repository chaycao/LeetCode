import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chayc on 2017/9/17.
 * 3ms
 * 递归，没直接用链表做，转成数组，方便随机取数
 * 若用链表做，设置两个指针，快指针，慢指针
 * 快指针的步长为2，慢指针步长为1.
 * 当快指针走到尾部时，慢指针指向中间的节点
 */
public class Solution_109 {
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
        TreeNode root = null;
        if (head == null) {
            return root;
        }
        ListNode p = head;
        List<Integer> list = new ArrayList<>();
        while (p != null) {
            list.add(p.val);
            p = p.next;
        }
        root = fun(list, 0, list.size()-1);
        return root;
    }
    public TreeNode fun(List<Integer> list, int start, int end) {
        int index = (end-start)/2 + start;
        TreeNode root = new TreeNode(list.get(index));
        // 构造左右子树
        if (index > start) {
            root.left = fun(list, start, index-1);
        }
        if (index < end) {
            root.right = fun(list, index+1, end);
        }
        return root;
    }
}