package lcof_63;

/**
 * @author: gefeng
 * @created: 2021/07/21 08:24
 */
public class offer63 {
    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(new int[]{7,6,4,3,1}));
    }
}


/**\
 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 *
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 */
class Solution {
    // dp[i] 表示第i天卖出的最大利润
    // dp[i] = dp[i-1] , prices[i] - min(prices[0]...prices[0])
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int dp[] = new int[prices.length];
        int min = prices[0];
        dp[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i] = Math.max(dp[i-1],prices[i] - min);
            if (prices[i] < min) {
                min = prices[i];
            }
        }
        return dp[prices.length-1];
    }
}
