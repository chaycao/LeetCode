import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by chayc on 2017/10/5.
 */
public class Soluton_136 {
    public int singleNumber(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (list.contains(n)) {
                list.remove((Integer)n);
            } else
                list.add(n);
        }
        return list.get(0);
    }
}
