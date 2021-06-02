package other;

/**
 * @author s1mple
 * @create 2021/6/1-19:42
 */
public class PackagePrombleDemo {

    public static int packageProbolem1() {
        int packageConatainWeight = 4;//包最大可装重量
        int[] weight = {1, 4, 3};//3个物品的重量
        int[] value = {150, 300, 200};//3个物品的价值
        int[][] dp = new int[weight.length + 1][packageConatainWeight + 1];
        for (int i = 1; i <= value.length; i++) {
            for (int j = 1; j <= packageConatainWeight; j++) {
                if (j >= weight[i - 1]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i - 1]] + value[i - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[weight.length][packageConatainWeight];
    }
}
