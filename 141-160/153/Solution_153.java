/**
 * Created by chaycao on 2017/10/19.
 * chaycao@163.com
 */
public class Solution_153 {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length-1;
        while (left < right) {
            if (nums[left] < nums[right])
                return nums[left];
            int mid = (left + right) / 2;
            if (nums[mid] > nums[right]) {
                left = mid+1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}
