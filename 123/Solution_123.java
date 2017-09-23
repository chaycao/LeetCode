import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by chayc on 2017/9/23.
 */
public class Solution_123 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2)
            return 0;
        int length = prices.length;
        int[] profit_first = new int[length];
        int[] profit_seconde = new int[length];

        int min = prices[0];
        for (int i = 1; i < length; i++) {
            min = Math.min(min, prices[i]);
            profit_first[i] = Math.max(profit_first[i-1], prices[i] - min);
        }

        int max = prices[length-1];
        for (int i = length-2; i >= 0; i--) {
            max = Math.max(max, prices[i]);
            profit_seconde[i] = Math.max(profit_seconde[i-1], max - prices[i]);
        }

        int result = 0;
        for (int i = 0; i < length; i++) {
            result = Math.max(result, profit_first[i] + profit_seconde[i]);
        }

        return result;
    }
}
