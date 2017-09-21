/**
 * Created by chayc on 2017/9/21.
 */
public class Solution_121 {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else if (prices[i] - min > result) {
                result = prices[i] - min;
            }
        }
        return result;
    }

}
