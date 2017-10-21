/**
 * Created by chaycao on 2017/10/21.
 * chaycao@163.com
 */
public class Solution_162 {
    public int findPeakElement(int[] nums) {
        int len = nums.length;
        if (len == 1)
            return 0;
        if (nums[0] > nums[1])
            return 0;
        if (nums[len-1] > nums[len-2])
            return len-1;
        for (int i = 1; i < len-2; i++) {
            System.out.println(i);
            if (nums[i] > nums[i-1] && nums[i] > nums[i+1])
                return i;
        }
        return 0;
    }
}
