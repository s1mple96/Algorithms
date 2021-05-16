package dp;

//给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
//
// 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
//
// 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
//
//
// 示例 1：
//
//
//输入：[7,1,5,3,6,4]
//输出：5
//解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
//     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
//
//
// 示例 2：
//
//
//输入：prices = [7,6,4,3,1]
//输出：0
//解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
//
//
//
//
// 提示：
//
//
// 1 <= prices.length <= 105
// 0 <= prices[i] <= 104
//
// Related Topics 数组 动态规划
// 👍 1620 👎 0

/**
 * @author s1mple
 * @create 2021/5/13-19:50
 */
public class GetMaxProfit {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        GetMaxProfit maxProfit = new GetMaxProfit();
        int res = maxProfit.maxProfit(prices);
        System.out.println(res);
    }
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int length = prices.length;
        int[][] dp = new int[length][2];
        //边界条件
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < length; i++) {
            /**
             * 定义一个二维数组dp[length][2]
             * dp[i][0]:i+1天 没有持有股票的最大利润
             *      ①第i+1天我们既没有买也没有卖,那么最大利润就是第i天没持有股票的最大利润dp[i-1][0]
             *      ②第i+1天我们卖了一只股票,那么最大利润就是第i天持有的股票的最大利润加上第i+1天卖出股票的最大利润dp[i-1[1]+prices[i]
             * dp[i][1]:i+1天 持有股票的最大利润
             * dp[i][0/1]:0/1 表示是否持有股票
             */
            //递推公式
            //没有持有股票的最大利润
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            //持有股票的最大利润
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        //毋庸置疑,最后肯定是手里没有持有股票利润才会最大,也就是卖出去了
        return dp[length - 1][0];
    }
}
