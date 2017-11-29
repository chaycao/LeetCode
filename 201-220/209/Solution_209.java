import org.omg.CORBA.INTERNAL;

import java.util.ArrayList;

/**
 * Created by chaycao on 2017/11/29.
 * chaycao@163.com
 */
public class Solution_209 {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int len = nums.length;
        int min = Integer.MAX_VALUE;
        int i = 0, j = 0, sum = 0;
        while (j < len) {
            sum += nums[j];
            j++;
            while (sum >= s) {
                min = Math.min(min, j-i);
                sum -= nums[i];
                i++;
            }
        }
        if (min == Integer.MAX_VALUE)
            return 0;
        return min;
    }
}
