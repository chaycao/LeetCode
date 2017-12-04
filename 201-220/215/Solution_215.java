import java.util.PriorityQueue;

/**
 * Created by chaycao on 2017/12/4.
 * chaycao@163.com
 */
public class Solution_215 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        for (int i = 0; i < nums.length; i++) {
            queue.offer(nums[i]);
            if (queue.size() > k) queue.poll();
        }
        return queue.poll();
    }
}
