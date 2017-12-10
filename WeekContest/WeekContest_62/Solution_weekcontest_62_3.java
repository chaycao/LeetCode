import java.util.ArrayList;
import java.util.List;

/**
 * Created by chaycao on 2017/12/10.
 * chaycao@163.com
 */
public class Solution_weekcontest_62_3 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    private List<Integer> list = new ArrayList<>();
    private List<Integer> leaf = new ArrayList<>();
    private int target_index;
    public int findClosestLeaf(TreeNode root, int k) {
        search(root, k);
        if (leaf.contains(k))
            return k;
        int i = target_index-1, j = target_index+1;
        while (true) {

            if (i >= 0) {
                if (leaf.contains(list.get(i))) {
                    return list.get(i);
                }
                i--;
            }
            if (j < list.size()) {
                if (leaf.contains(list.get(j))) {
                    return list.get(j);
                }
                j++;
            }
        }
    }

    public void search(TreeNode root, int k) {
        if (root.left == null && root.right == null)
            leaf.add(root.val);

        if (root.left!=null)
            search(root.left, k);

        list.add(root.val);
        if (root.val == k)
            target_index = list.size()-1;

        if (root.right!=null)
            search(root.right, k);

    }

}
