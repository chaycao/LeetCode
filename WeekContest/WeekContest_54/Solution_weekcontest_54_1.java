import java.util.*;

/**
 * Created by chayc on 2017/10/15.
 */
public class Solution_weekcontest_54_1 {
    public int findShortestSubArray(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        HashMap<Integer, Integer> count = new HashMap<>();
        HashMap<Integer, Integer> first = new HashMap<>();
        HashMap<Integer, Integer> len = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (!count.containsKey(n)) {
                count.put(n, 1);
                len.put(n, 1);
                first.put(n, i);
            } else {
                int c = count.get(n);
                count.put(n, c+1);
                int f = first.get(n);
                len.put(n, i-f+1);
            }
        }
        int max = 0;
        List<Integer> list = new ArrayList<Integer>();
        Iterator<Map.Entry<Integer, Integer>> entries = count.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<Integer, Integer> entry = entries.next();
            int key = entry.getKey();
            int value = entry.getValue();
            if (max < value) {
                max = value;
                list.clear();
                list.add(key);
            }
            if (max == value) {
                list.add(key);
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list.size(); i++) {
            int n = list.get(i);
            if (min > len.get(n))
                min = len.get(n);
        }
        return min;
    }
}
