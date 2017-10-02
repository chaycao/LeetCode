import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by chayc on 2017/9/14.
 * 思路是基于102的两个队列做的，只不过这里用的stack。
 * 根据层数，来决定从左往右 或 从右往左
 */
public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)
            return result;
        Stack<TreeNode> currentStack = new Stack<>();
        Stack<TreeNode> nextStack = new Stack<>();
        List<Integer> listVal = new ArrayList<>();
        currentStack.push(root);
        listVal.add(root.val);
        result.add(listVal);
        int flag = -1;
        while (currentStack.empty() != true) {
            TreeNode n = currentStack.pop();

            if (flag == 1) { // 从左往右
                if(n.left != null) {
                    nextStack.push(n.left);
                }
                if(n.right != null) {
                    nextStack.push(n.right);
                }
            } else { // 从右往左
                if(n.right != null) {
                    nextStack.push(n.right);
                }
                if(n.left != null) {
                    nextStack.push(n.left);
                }
            }

            // 若firstStack空了，一层元素取完了
            if (currentStack.empty() == true) {
                List<TreeNode> listNode = new ArrayList<>(nextStack);
                listVal = new ArrayList<>();
                if (listNode.size() == 0)
                    return result;
                for (int i = 0; i < listNode.size(); i++) {
                    listVal.add(listNode.get(i).val);
                }
                result.add(listVal);
                currentStack = nextStack;
                nextStack = new Stack<>();
                flag = 0 - flag;
            }
        }

        return result;

    }
}
