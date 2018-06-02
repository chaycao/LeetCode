import java.util.Arrays;
import java.util.List;

/**
 * @author chaycao
 * @description
 * @date 2018-06-02 21:03.
 */
public class Solution_377 {

    private static int[][] dp;

    public static int combinationSum4(int[] nums, int target) {
        int n = nums.length;
        int dp[] = new int[target+1];
        Arrays.fill(dp, -1);
        return solve(nums, target, dp);
    }

    public static int solve(int nums[], int target, int[] dp) {
        if (target <= 0)
            return target == 0 ? 1 : 0;
        if (dp[target] != -1)
            return dp[target];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target-nums[i] >= 0) {
                count += solve(nums, target-nums[i], dp);
            }
        }
        return dp[target] = count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int target = 4;
        System.out.println(combinationSum4(nums, target));
    }

}
