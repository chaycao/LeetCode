/**
 * Created by chaycao on 2017/11/23.
 * chaycao@163.com
 */
public class Solution_191 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result += n & 1;
            n >>>= 1;
        }
        return result;
    }
}
