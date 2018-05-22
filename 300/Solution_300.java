/**
 * @author chaycao
 * @description
 * @date 2018-05-22 19:07.
 */
public class Solution_300 {

    public static int lengthOfLIS(int[] nums) {
        int[] state = new int[nums.length];
        int size = 0;
        for (int x : nums) {
            int i = 0;
            int j = size;
            while (i != j) {
                int mid = (i+j)/2;
                if (x > state[mid]) {
                    i = mid +1;
                } else {
                    j = mid;
                }
            }
            state[i] = x;
            if (i == size)
                size++;
        }
        return size;
    }

    public static void main(String[] args) {
        int[] x = {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(x));
    }
}
