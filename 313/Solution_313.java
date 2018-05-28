/**
 * @author chaycao
 * @description
 * @date 2018-05-28 22:09.
 */
public class Solution_313 {
    public static int nthSuperUglyNumber(int n, int[] primes) {
        int[] point = new int[primes.length];
        int[] ugly = new int[n];
        ugly[0] = 1;
        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            int min_index = 0;
            for (int j = 0; j < primes.length; j++) {
                int temp = primes[j] * ugly[point[j]];
                if (temp < min) {
                    min = temp;
                    min_index = j;
                } else if (temp == min) {
                    point[j]++;
                }
            }
            ugly[i] = min;
            point[min_index]++;
        }
        return ugly[n-1];
    }

    public static void main(String[] args) {
        int[] primes = new int[]{2, 7, 13, 19};
        System.out.println(nthSuperUglyNumber(12, primes));
    }
}
