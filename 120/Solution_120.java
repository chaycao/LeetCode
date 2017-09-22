import java.util.ArrayList;
import java.util.List;

/**
 * Created by chayc on 2017/9/22.
 */
public class Solution_120 {
    private int min = Integer.MAX_VALUE;
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0)
            return 0;
        for (int i = triangle.size() - 1; i > 0; i--) {
            for (int j = 0; j < triangle.get(i).size() - 1; j++) {
                int val = triangle.get(i-1).get(j);
                val += Math.min(triangle.get(i).get(j), triangle.get(i).get(j+1));
                triangle.get(i-1).set(j, val);
            }
        }
        return triangle.get(0).get(0);
    }
}
