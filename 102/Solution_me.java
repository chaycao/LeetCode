import java.util.*;

/**
 * Created by chayc on 2017/9/13.
 * 34ms
 * 一拿到题，觉得是个广度搜索问题，
 * 然后才发现，问题在于，level的区分。需要把一层一层的用List分开，并加到resultList里
 * 我的想法是：为每个节点都设一个Level的记录，也就是每个节点都有个对应的level值
 * 表示这个节点在第几层
 * 在广度搜索中，每次取点的时候，根据level值判断
 * 若已进入到新的一层，则把当前list加到resultList中。
 * 否则，直接加入到list里
 *
 * 我这个做法的问题也在于记录level值，不能修改TreeNode的结构。= =！
 * 然后我就用了个HashMap来存，也没想到别的方法。
 */
public class Solution_me {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resultList = new ArrayList<List<Integer>>();
         if(root == null)
             return resultList;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        Map<TreeNode, Integer> treeLevel = new HashMap<TreeNode, Integer>();
        treeLevel.put(root, 0);
        int leve = 0;
        List<Integer> list = new ArrayList<Integer>();
        while (queue.size() != 0) {
            TreeNode x = queue.remove();
            int x_leve = treeLevel.get(x);
            System.out.println(""+x.val + " " +x_leve);
            // 进入到下一层， 需要把之前的List 加到 result里，new一个list
            if (x_leve != leve) {
                resultList.add(list);
                list = new ArrayList<Integer>();
                leve = x_leve;
            } else {
                list.add(x.val);
            }
            if (x.left != null) {
                queue.add(x.left);
                treeLevel.put(x.left, x_leve + 1);
            }
            if (x.right != null) {
                queue.add(x.right);
                treeLevel.put(x.right, x_leve + 1);
            }
        }

        return resultList;

    }
}
