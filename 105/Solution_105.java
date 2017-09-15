import java.util.*;

/**
 * Created by chayc on 2017/9/15.
 * 7ms
 * 类似二分法的思想，递归下去，找左右节点
 */
public class Solution_105 {
    public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0)
            return null;
        TreeNode root = new TreeNode(preorder[0]);
        HashMap<Integer, Integer> preMap = new HashMap<>();
        HashMap<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < preorder.length; i++)
        {
            preMap.put(preorder[i], i);
            inMap.put(inorder[i], i);
        }
        fun(0, preorder.length, preorder[0], preorder, inorder, root, preMap, inMap);
        return root;
    }

    public void fun(int start, int end, int n, int[] preorder, int[] inorder, TreeNode node, Map<Integer, Integer> preMap, Map<Integer, Integer> inMap) {
        if(start == end -1)
            return;
        int index_pre = preMap.get(n);
        int index_in = inMap.get(n);

        if (index_in > start) { // 左边有，则preorder的index + 1 为Node的左子树
            int left = preorder[index_pre+1];
            TreeNode left_node = new TreeNode(left);
            node.left = left_node;
            fun(start, index_in, left, preorder, inorder, left_node, preMap, inMap);
        }
        if (index_in < end-1) { // 右边有，则preorder的index_in+index_pre-start+1为Node的右子树
            int right = preorder[index_in+index_pre-start+1];
            TreeNode right_node = new TreeNode(right);
            node.right = right_node;
            fun(index_in + 1 , end, right, preorder, inorder, right_node, preMap, inMap);
        }
    }
}