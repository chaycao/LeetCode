import java.util.ArrayList;
import java.util.List;

/**
 * Created by chayc on 2017/9/16.
 * 一开始是想着用中序遍历，将其投影，但对于[1,2,3,3,null,2,null]
 * 缺少了层的信息，就把List改成数组，加上层的信息。
 */
public class Solution_101 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public boolean isSymmetric(TreeNode root) {
        boolean result = true;
        if (root == null)
            return true;

        List<int[]> list = new ArrayList<>();
        fun(list, root, 0);
        for(int i = 0; i < list.size()/2; i++) {
            if(list.get(i)[0] != list.get(list.size()-1-i)[0] || list.get(i)[1] != list.get(list.size()-1-i)[1]) {
                result = false;
                break;
            }
        }
        return result;
    }
    public void fun(List<int[]> list, TreeNode root, int index){
        if (root.left != null) {
            fun(list, root.left, index+1);
        }
        int[] n = {root.val, index};
        list.add(n);
        if (root.right != null) {
            fun(list, root.right, index+1);
        }
    }
}
