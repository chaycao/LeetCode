import java.util.ArrayList;
import java.util.List;

/**
 * Created by chayc on 2017/9/20.
 */
public class Solution_118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows <= 0)
            return result;

        List<Integer> first = new ArrayList<>();
        List<Integer> seconde = new ArrayList<>();
        first.add(1);
        result.add(new ArrayList<>(first));
        for (int i = 1; i < numRows; i++) {
            seconde.add(1);
            for (int j = 1; j < i; j++) {
                seconde.add(first.get(j-1)+first.get(j));
            }
            seconde.add(1);
            result.add(new ArrayList<>(seconde));
            first = seconde;
            seconde = new ArrayList<>();
        }
        return result;
    }
}
