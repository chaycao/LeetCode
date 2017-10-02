import java.util.ArrayList;
import java.util.List;

/**
 * Created by chayc on 2017/9/21.
 */
public class Solution_119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        result.add(1);
        if (rowIndex == 0)
            return result;
        result.add(1);
        if (rowIndex == 1)
            return result;
        for (int i = 1; i < rowIndex; i++) {
            int temp_pre = 1;
            int temp_next = 0;
            for (int j = 1; j < i+1; j++) {
                temp_next = result.get(j);
                result.set(j, result.get(j) + temp_pre);
                temp_pre = temp_next;
            }
            result.add(1);
        }
        return result;
    }
}
