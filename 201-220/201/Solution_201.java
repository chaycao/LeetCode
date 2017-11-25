/**
 * Created by chaycao on 2017/11/25.
 * chaycao@163.com
 */
public class Solution_201 {
    public static int rangeBitwiseAnd(int m, int n) {
        int result = 1;
        if (m == 0)
            return 0;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            result <<= 1;
        }
        return m * result;
    }

    public static void main(String[] args) {
        int a = 1;
        System.out.println(rangeBitwiseAnd(4,8));
    }
}
