/**
 * Created by chayc on 2017/9/21.
 */
public class Solution_122 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0)
            return 0;
        int result = 0;
        int current = 0;
        int buy = prices[0];
        int sell = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length-1; i++) {
            if (prices[i] < prices[i+1]) { // 涨的情况下，准备卖，先存起来
                sell = prices[i+1];
            } else { // 一旦跌价，且之前记录了，准备卖的点，就直接卖出
                if (sell > 0) { //直接卖出
                    result += sell - buy;
                    //System.out.println(i+ " " +(sell-buy));
                    sell = Integer.MIN_VALUE;
                }
                buy = prices[i+1]; // 跌价买入，若之前有买入，则刷新 最低值，买入
            }
        }
        if (sell > 0) //处理最后两个个点的情况，若有涨价，则卖出
            result += sell - buy;

        return result;
    }
}
