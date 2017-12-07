/**
 * Created by chaycao on 2017/12/7.
 * chaycao@163.com
 */
public class Solution_222 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;
        int left = 0;
        int right = 0;
        TreeNode p = root;
        while (p.left != null) {
            p = p.left;
            left++;
        }
        p = root;
        while (p.right != null) {
            p = p.right;
            right++;
        }
        if (left == right) {
            return (1 << (left+1)) - 1;
        }
        return helperLeft(root.left, left - 1) +  helperRight(root.right, right - 1) + 1;
    }

    public int helperLeft(TreeNode root, int left) {
        if (root == null)
            return 0;
        TreeNode p = root;
        int right = 0;
        while (p.right != null) {
            p = p.right;
            right++;
        }
        if (left == right) {
            return (1 << (left+1)) - 1;
        }
        return helperLeft(root.left, left - 1) + helperRight(root.right, right - 1) + 1;
    }

    public int helperRight(TreeNode root, int right) {
        if (root == null)
            return 0;
        TreeNode p = root;
        int left = 0;
        while (p.left != null) {
            p = p.left;
            left++;
        }
        if (left == right) {
            return (1 << (left+1)) - 1;
        }
        return helperLeft(root.left, left - 1) +  helperRight(root.right, right - 1) + 1;
    }

}
