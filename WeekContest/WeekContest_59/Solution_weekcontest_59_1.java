import java.util.ArrayList;
import java.util.List;

/**
 * Created by chaycao on 2017/11/19.
 * chaycao@163.com
 */
public class Solution_weekcontest_59_1 {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (helper(i) == true)
                result.add(i);
        }
        return result;
    }
    public boolean helper(int n) {
        String s = Integer.toString(n);
        if (s.length() == 1)
            return true;
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; i++) {
            int x = c[i] - 48;
            if (x == 0)
                return false;
        }
        for (int i = 0; i < c.length; i++) {
            int x = c[i] - 48;
            if (n % x == 0)
                continue;
            else
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_weekcontest_59_1().selfDividingNumbers(1, 22));
    }
}
