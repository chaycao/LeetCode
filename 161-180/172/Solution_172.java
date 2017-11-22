/**
 * Created by chaycao on 2017/11/21.
 * chaycao@163.com
 */
public class Solution_172 {
    public int trailingZeroes(int n) {
        int r = 0;
        while (n != 0) {
            n /= 5;
            r += n;
        }
        return r;
    }
}
