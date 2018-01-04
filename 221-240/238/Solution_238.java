/**
 * Title:
 *
 * @author chaycao
 * @description:
 * @date 2018-01-04 10:31.
 *
 * 不能用除法，O(n)，常量空间
 *
 * 每个数存双向乘法的结果
 * 可以直接通过返回的数组保存中间结果
 *
 */
public class Solution_238 {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i-1] * nums[i-1];
        }
        int right = 1;
        for (int i = n-1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }
}
