/**
 * Title:
 *
 * @author chaycao
 * @description:
 * @date 2018-01-10 21:55.
 */
public class Solution_263 {
    public boolean isUgly(int num) {
        if (num < 0)
            return false;
        while (num != 1) {
            if (num % 2 == 0) {
                num /= 2;
                continue;
            }
            if (num % 3 == 0) {
                num /= 3;
                continue;
            }
            if (num % 5 == 0) {
                num /= 5;
                continue;
            }
            break;
        }
        return num == 1 ? true : false;
    }
}
