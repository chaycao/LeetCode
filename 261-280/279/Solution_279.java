/**
 * Title:
 *
 * @author chaycao
 * @description:
 * @date 2018-04-07 09:52.
 */
public class Solution_279 {
    public static int numSquares(int n) {
        int count = 0;
        while (n>0) {
            int x = (int)Math.floor(Math.sqrt(n));
            n -= x*x;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(numSquares(12));
    }
}
