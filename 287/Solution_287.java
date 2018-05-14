/**
 * @author chaycao
 * @description
 * @date 2018-05-14 22:43.
 */
public class Solution_287 {
    public int findDuplicate(int[] nums) {
        int high = nums.length-1;
        int low = 1;
        while (low < high) {
            int mid = low+(high+low)/2;
            int count = 0;
            for (int num : nums) {
                if (num <= mid) {
                    count++;
                }
            }
            if (count <= mid) {
                low = mid+1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
