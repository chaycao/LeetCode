import java.util.*;

/**
 * Created by chaycao on 2017/11/25.
 * chaycao@163.com
 */
public class Solution_204 {
    public int countPrimes(int n) {
        int count = 0;
        if (n < 3)
            return 0;
        boolean[] flag = new boolean[n];
        for (int i = 2; i < n; i++) {
            if (flag[i] == false) {
                count++;
                for (int j = 2; i * j < n; j++) {
                    flag[i*j] = true;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution_204 s = new Solution_204();
        System.out.println(s.countPrimes(100));
    }
}
