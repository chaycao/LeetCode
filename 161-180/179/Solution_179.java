/**
 * Created by chaycao on 2017/10/27.
 * chaycao@163.com
 */
public class Solution_179 {
    public String largestNumber(int[] nums) {
        sort(nums, 0, nums.length-1);
        StringBuilder result = new StringBuilder();
        if (nums[nums.length-1] == 0)
            return "0";
        for (int i = nums.length-1; i >= 0; i--) {
            result.append(nums[i]);
        }
        return result.toString();
    }
    public void sort(int[] nums, int low, int high) {
        if (low >= high)
            return;
        int index = partition(nums, low, high);
        sort(nums, low, index-1);
        sort(nums, index+1, high);
    }
    public int partition(int[] nums, int low, int high) {
        int key = nums[low];
        while (low < high) {
            while (compare(nums[high], key) >= 0  && high > low) {
                high--;
            }
            nums[low] = nums[high];
            while (compare(nums[low], key) <= 0 && high > low) {
                low++;
            }
            nums[high] = nums[low];
        }
        nums[high] = key;
        return high;
    }
    public int compare(int a, int b) {
        String str1 = String.valueOf(a);
        String str2 = String.valueOf(b);
        String s1 = str1 + str2;
        String s2 = str2 + str1;
        return s1.compareTo(s2);
    }

    public static void main(String[] args) {
        System.out.println(new Solution_179().compare(3,2));
    }
}
