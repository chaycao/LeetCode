import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Created by chayc on 2017/9/26.
 */
public class Solution_128 {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int result = 0;
        for (int n : nums) {
            if (!map.containsKey(n)) {
                int left = (map.containsKey(n-1)) ? map.get(n-1) : 0;
                int right = (map.containsKey(n+1)) ? map.get(n+1) : 0;
                int size = 1 + left + right;
                map.put(n, size);
                if (size > result)
                    result = size;
                map.put(n - left, size);
                map.put(n + right, size);
            } else {
                continue;
            }
        }
        return result;
    }
}
