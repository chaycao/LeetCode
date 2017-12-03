/**
 * Created by chaycao on 2017/12/3.
 * chaycao@163.com
 */
public class Solution_213 {
    public int rob(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        if (nums.length == 2)
            return Math.max(nums[0], nums[1]);
        if (nums.length == 3)
            return Math.max(nums[0], Math.max(nums[1], nums[2]));
        // 1. 第一个房子偷，最后一个房子不偷，直接跳过
        int preYes = nums[0], preNo = nums[0], temp = 0;
        for (int i = 2; i < nums.length-1; i++) {
            temp = preNo;
            preNo = Math.max(preNo, preYes);
            preYes = temp + nums[i];
        }
        int res1 = Math.max(preNo, preYes);
        // 2. 第一个房子不偷，直接跳过
        preNo = 0;
        preYes = 0;
        for (int i = 1; i < nums.length; i++) {
            temp = preNo;
            preNo = Math.max(preNo, preYes);
            preYes = temp + nums[i];
        }
        int res2 = Math.max(preNo, preYes);
        return Math.max(res1, res2);
    }
}
