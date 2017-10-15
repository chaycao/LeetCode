import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by chayc on 2017/10/15.
 */
public class Solution_weekcontest_54_3 {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        int len = nums.length;
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        Collections.sort(list);
        List<List<Integer>> all_list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(list.get(len-i-1));
            all_list.add(temp);
        }
        if (len < k*2) {
            int target = list.get(len-1);
            int x = k*2 - len;
            int j = len - x - 1;
            if (x > 1)
            {
                if (list.get(len-x) != target)
                    return false;
                x--;
            }
            int i = 0;
            while (i<j) {
                if (list.get(i) + list.get(j) != target)
                    return false;
                i++;
                j--;
            }
        }
    }
}
