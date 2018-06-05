import java.util.Arrays;

/**
 * @author chaycao
 * @description
 * @date 2018-06-04 20:26.
 */
public class Solution_416 {
    public static boolean canPartition(int[] nums) {
        if (nums == null || nums.length < 2)
            return false;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 == 1)
            return false;
        Arrays.sort(nums);
        int a = 0, b = 0;
        a = nums[nums.length-1];
        sum -= nums[nums.length-1];
        return dfs(nums, nums.length-2, a, b, sum);
    }

    public static boolean dfs(int[] nums, int index, int a, int b, int sum) {
        if (Math.abs(a-b) > sum) { // a b两个集合之间的差值大于剩余的总量
            return false;
        } else if (Math.abs(a-b) == sum) {
            return true;
        }
        if (index == nums.length)
            return false;
        int n = nums[index];
        if (dfs(nums, index-1, a+n, b, sum-n) == true)
            return true;
        if (dfs(nums, index-1, a, b+n, sum-n) == true)
            return true;
        return false;
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        int[] nums = {17,58,41,75,61,70,52,7,38,11,40,58,44,45,4,81,67,54,79,80,15,3,14,16,9,66,69,41,72,37,28,3,33,90,56,12,72,49,35,22,49,27,49,82,41,77,100,82,18,95,24,51,37,2,34,82,70,53,73,32,90,98,81,22,73,76,79,40,27,62,45,96,36,15,63,28,54,88,63,37,58,9,62,98,93,72,99,53,91,29,61,31,11,42,20,35,50,68,10,86};
        System.out.println(canPartition(nums));
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }
}
