/**
 * Created by chaycao on 2017/10/31.
 * chaycao@163.com
 */
public class Solution_553 {
    public String optimalDivision(int[] nums) {
        int len = nums.length;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < len-1; i++) {
            result.append(nums[i]);
            if (len > 2 && i == 0)
                result.append("/(");
            else
                result.append("/");
        }
        result.append(nums[len-1]);
        if (len > 2)
            result.append(")");
        return result.toString();
    }
}
