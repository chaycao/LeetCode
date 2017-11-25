import java.util.HashMap;

/**
 * Created by chaycao on 2017/11/25.
 * chaycao@163.com
 */
public class Solution_202 {
    public boolean isHappy(int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        do {
            if (n == 1)
                return true;
            map.put(n, 1);
            n = helper(n);
//            System.out.println(n);
        } while (!map.containsKey(n));
        return false;
    }
    public int helper(int n) {
        int result = 0;
        while (n != 0) {
            int  x = n % 10;
            result += x * x;
            n /= 10;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution_202 s = new Solution_202();
        System.out.println(s.isHappy(49));
    }
}
