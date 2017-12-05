import java.util.ArrayList;
import java.util.List;

/**
 * Created by chaycao on 2017/12/5.
 * chaycao@163.com
 */
public class Solution_216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(k, n, list, result);
        return result;
    }
    public void helper(int k, int n, List<Integer> list, List<List<Integer>> result) {
        if (list.size() == k) {
            int sum = 0;
            for (int x : list) {
                sum += x;
            }
            if (n == sum)
            {
                result.add(new ArrayList<>(list));
            }
        }
        int i = 0;
        if (list.size() != 0)
           i = list.get(list.size()-1);
        if (i == 9)
            return;
        i++;
        for (; i <=9; i++) {
            list.add(i);
            helper(k, n, list, result);
            list.remove(list.size()-1);
        }
    }
}
