/**
 * Created by chaycao on 2017/11/22.
 * chaycao@163.com
 */
public class Solution_189 {
    public void rotate(int[] nums, int k) {
        int[] temp = new int[k];
        if (k == 0) return;
        if (k >= nums.length)
            k %= nums.length;
        int j = 0;
        for (int i = nums.length-k; i < nums.length; i++) {
            temp[j++] = nums[i];
        }
        for (int i = nums.length-1-k; i >= 0; i--) {
            nums[i+k] = nums[i];
        }
        for (int i = 0; i < k; i++) {
            nums[i] = temp[i];
        }
        return;
    }
}
