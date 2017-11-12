/**
 * Created by chaycao on 2017/11/12.
 * chaycao@163.com
 */
public class Solution_weekcontest_58_1 {
    public int pivotIndex(int[] nums) {
        return helper(nums, 0, nums.length);
    }
    public int helper(int[] nums, int left, int right) {
        int mid = (left+right)/2;
        int a_sum = 0;
        int b_sum = 0;
        if (left >= right)
            return -1;
        for (int i = 0; i < mid; i++) {
            a_sum += nums[i];
        }
        for (int i = mid+1; i < nums.length; i++) {
            b_sum += nums[i];
        }

        int a = helper(nums, left, mid);
        if (a != -1)
            return a;
        if (a_sum == b_sum)
            return mid;
        int b = helper(nums, mid+1, right);
        if (b != -1)
            return b;
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {1,7,3,6,5,6};
        int[] b = {-1,-1,0,0,-1,-1};
        System.out.println(new Solution_weekcontest_58_1().pivotIndex(b));
    }
}
