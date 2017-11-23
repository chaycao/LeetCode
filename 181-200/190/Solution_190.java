import java.util.Collections;

/**
 * Created by chaycao on 2017/11/22.
 * chaycao@163.com
 */
public class Solution_190 {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result += n & 1;
            n >>>= 1;   // CATCH: must do unsigned shift
            if (i < 31) // CATCH: for last digit, don't shift!
                result <<= 1;
        }
        return result;
    }



    public static void main(String[] args) {
        System.out.println(new Solution_190().reverseBits(1 ));
    }
}
