import java.util.ArrayList;
import java.util.List;

/**
 * Created by chaycao on 2017/10/25.
 * chaycao@163.com
 */
public class Solution_173 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    class BSTIterator {

        private TreeNode root;
        private List<Integer> list;
        private int index = 0;

        public BSTIterator(TreeNode root) {
            this.root = root;
            list = new ArrayList<>();
            helper(root);
            index = 0;
        }

        public void helper(TreeNode root) {
            if (root == null) return;
            helper(root.left);
            list.add(root.val);
            helper(root.right);
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            if (index < list.size())
                return true;
            return false;
        }

        /** @return the next smallest number */
        public int next() {
            return list.get(index++);
        }
    }
}
