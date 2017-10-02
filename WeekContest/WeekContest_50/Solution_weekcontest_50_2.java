import java.util.HashMap;
import java.util.Map;

/**
 * Created by chayc on 2017/9/17.
 */
public class Solution_weekcontest_50_2 {
    class MapSum {
        Map<String, Integer> map = new HashMap<>();

        /** Initialize your data structure here. */
        public MapSum() {
        }

        public void insert(String key, int val) {
            map.put(key, val);
        }

        public int sum(String prefix) {
            int sum = 0;
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (entry.getKey().startsWith(prefix))
                    sum += entry.getValue();
            }
            return sum;
        }
    }
}
