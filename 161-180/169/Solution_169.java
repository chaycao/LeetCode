import java.util.HashMap;

/**
 * Created by chaycao on 2017/11/21.
 * chaycao@163.com
 */
public class Solution_169 {
    public int majorityElement(int[] nums) {
        int len = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (map.containsKey(nums[i])) {
                int count = map.get(nums[i]);
                count++;
                if (count > len / 2)
                    return nums[i];
                map.put(nums[i], count);
            } else {
                map.put(nums[i], 1);
            }
        }
        return nums[0];
    }
}
