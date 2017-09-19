import java.util.ArrayList;
import java.util.List;

/**
 * Created by chayc on 2017/9/19.
 * 每个节点比较左右的深度
 * 节点将左右深度的最大值，往上传给父节点，父节点在该值基础上加1
 */
public class Solution_108 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = null;
        if (nums == null || nums.length == 0) {
            return root;
        }
        root = fun(nums, 0, nums.length-1);
        return root;

    }
    public TreeNode fun(int[] nums, int start, int end) {
        int index = (end-start)/2 + start;
        TreeNode root = new TreeNode(nums[index]);
        // 构造左右子树
        if (index > start) {
            root.left = fun(nums, start, index-1);
        }
        if (index < end) {
            root.right = fun(nums, index+1, end);
        }
        return root;
    }
}
