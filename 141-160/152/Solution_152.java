/**
 * Created by chayc on 2017/10/18.
 */
public class Solution_152 {
    public int maxProduct(int[] nums) {
        int len = nums.length;
        int pos[] = new int[len];
        int neg[] = new int[len];
        int result = Integer.MIN_VALUE;
        if (nums[0] > 0)
        {
            pos[0] = nums[0];
            neg[0] = 0;
        } else {
            pos[0] = 0;
            neg[0] = nums[0];
        }
        if (nums[0] > result)
            result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) {
                if (pos[i-1] != 0)
                    pos[i] = pos[i-1] * nums[i];
                else
                    pos[i] = nums[i];

                if(neg[i-1] != 0)
                    neg[i] = neg[i-1] * nums[i];
                else
                    neg[i] = 0;
            } else{
                if (pos[i-1] != 0)
                    neg[i] = pos[i-1] * nums[i];
                else
                    neg[i] = nums[i];

                if (neg[i-1] != 0)
                    pos[i] = neg[i-1] * nums[i];
                else
                    pos[i] = 0;
            }

            if (pos[i] > result)
                result = pos[i];
            if (neg[i] > result)
                result = neg[i];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] a = {-2,2};
        System.out.println(new Solution_152().maxProduct(a));
    }
}
