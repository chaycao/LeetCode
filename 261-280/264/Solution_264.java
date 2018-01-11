/**
 * Title:
 *
 * @author chaycao
 * @description:
 * @date 2018-01-11 13:54.
 */
public class Solution_264 {
    public int nthUglyNumber(int n) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        int index = 0, index1 = 0, index2 = 0, index3 = 0;
        int fact1 = 2, fact2 = 3, fact3 = 5;
        for (int i = 1; i < n; i++) {
            int min = Math.min(Math.min(fact1, fact2), fact3);
            ugly[++index] = min;
            if (fact1 == min) fact1 = 2*ugly[++index1];
            if (fact2 == min) fact2 = 3*ugly[++index2];
            if (fact3 == min) fact3 = 5*ugly[++index3];
        }
        return ugly[n-1];
    }
}
