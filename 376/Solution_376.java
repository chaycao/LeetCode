/**
 * @author chaycao
 * @description
 * @date 2018-05-30 19:32.
 */
public class Solution_376 {
    public static int wiggleMaxLength(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1)
            return 1;
        int len = nums.length;
        int flag; // 大于
        int[] res = new int[len];
        if (nums[1] < nums[0])
            flag = -1;
        else if (nums[1] == nums[0]) {
            flag = 0;
        } else {
            flag = 1;
        }
        if (flag == 0)
            res[1] = 1;
        else
            res[1] = 2;
        int pre_flag = flag;
        for (int i = 2; i < len; i++) {
            if (nums[i] < nums[i-1])
                flag = -1;
            else if (nums[i] == nums[i-1])
                flag = 0;
            else {
                flag = 1;
            }
            if (flag == 0 || flag == pre_flag)
            {
                res[i] = res[i-1];
                continue;
            }
            else {
                res[i] = res[i-1] + 1;
            }

            pre_flag = flag;
        }
        return res[len-1];
    }

    public static void main(String[] args) {
        int[] nums = {2,2,2};
        System.out.println(wiggleMaxLength(nums));
    }
}
