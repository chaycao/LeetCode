/**
 * @author chaycao
 * @description
 * @date 2018-05-26 23:17.
 */
public class Solution_309 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2)
            return 0;
        int has1_nothing = -prices[0];
        int has1_sell = 0;
        int has0_nothing = 0;
        int has0_buy = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            has1_nothing = has1_nothing > has0_buy ? has1_nothing : has0_buy;
            has0_buy = has0_nothing - prices[i];
            has0_nothing = has0_nothing > has1_sell ? has0_nothing : has1_sell;
            has1_sell = (has1_nothing > has0_buy ? has1_nothing : has0_buy) + prices[i];
        }
        return has1_sell > has0_nothing ? has1_sell : has0_nothing;
    }
}
