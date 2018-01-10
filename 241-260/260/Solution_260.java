/**
 * Title:
 *
 * @author chaycao
 * @description:
 * @date 2018-01-08 15:26.
 */
public class Solution_260 {
    public int[] singleNumber(int[] nums) {
        int temp = 0;
        for (int n : nums) {
            temp ^= n;
        }
        temp &= -temp;
        int a = 0, b = 0;
        int res[] = {0, 0};
        for (int n : nums) {
            if ((n & temp) == 0)
                res[0] ^= n;
            else {
                res[1] ^= n;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(Long.toBinaryString(-10000000000L));
    }
}
