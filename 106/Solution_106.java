import java.util.HashMap;
import java.util.Map;

/**
 * Created by chayc on 2017/9/16.
 * 心累。规则找错了。搞得很麻烦。。
 * 应该利用后序遍历，从后面找左右节点。。
 */
public class Solution_106 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode buildTree(int[] inorder, int[] posorder) {
        if (inorder.length == 0)
            return null;
        int len = inorder.length;
        TreeNode root = new TreeNode(posorder[len-1]);
        HashMap<Integer, Integer> inMap = new HashMap<>();
        HashMap<Integer, Integer> posMap = new HashMap<>();
        for (int i = 0; i < len; i++)
        {
            inMap.put(inorder[i], i);
            posMap.put(posorder[i], i);
        }
        fun(0, len,0, len, posorder[len-1], inorder, posorder, root, inMap, posMap);
        return root;
    }

    public void fun(int start_in, int end_in,int start_pos, int end_pos, int n, int[] inorder, int[] posorder, TreeNode node, Map<Integer, Integer> inMap,  Map<Integer, Integer> posMap) {
        int index_in = inMap.get(n);
        int index_pos = posMap.get(n);

        if(start_in == end_in - 1)
            return;
        //找在中序里的位置，左边的是所有的左子树及孩子
        //得到个数后，在后序里从start开始的最后一个就是该节点的左孩子
        int left_length = index_in-start_in;
        if (index_in > start_in) {
            int left = posorder[left_length+start_pos-1];
            System.out.println(left);
            TreeNode left_node = new TreeNode(left);
            node.left = left_node;
            fun(start_in, index_in, start_pos, start_pos+left_length, left, inorder, posorder, left_node, inMap, posMap);
        }
        if (index_in < end_in - 1) {
            int right = posorder[index_pos-1];
            TreeNode right_node =  new TreeNode(right);
            node.right = right_node;
            fun(index_in + 1, end_in, start_pos+left_length, end_pos-1, right, inorder, posorder, right_node, inMap, posMap);
        }
    }
}
