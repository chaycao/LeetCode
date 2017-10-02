import java.util.HashMap;

/**
 * Created by chayc on 2017/9/29.
 */
public class Solution_weekcontest_51_4 {
    public int kEmptySlots(int[] flowers, int k) {
        int[] index = new int[flowers.length+1];
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < flowers.length; i++) {
            index[flowers[i]] = i;
        }
        for (int i = 0; i < flowers.length; i++) {
            System.out.println(i);
            if (flowers[i] + k +1 < flowers.length) {
                int min_value = flowers[i];
                int max_value = flowers[i] + k + 1;
                int max_index = Math.max(index[flowers[i]], index[flowers[i]+k+1]);
                int flag = 1;
                for (int j = min_value + 1; j < max_value; j++) {
                    if (index[j] < max_index) {
                        flag = 0;
                        break;
                    }
                }
                if (flag == 1) result = Math.min(result, max_index+1);
            }
            if (flowers[i] - k - 1 > 0) {
                int min_value = flowers[i] - k - 1;
                int max_value = flowers[i];
                int max_index = Math.max(index[flowers[i]], index[flowers[i] - k - 1]);
                int flag = 1;
                for (int j = min_value + 1; j < max_value; j++) {
                    if (index[j] < max_index) {
                        flag = 0;
                        break;
                    }
                }
                if (flag == 1) result = Math.min(result, max_index+1);
            }
        }
        if (result == Integer.MAX_VALUE)
            return -1;
        else
            return result;
    }
}
