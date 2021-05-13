package 动态规划问题;

/**
 * 礼物的最大值
 * @author s1mple
 * @create 2021/5/13-16:58
 */
public class GetMaxValue {
    public int maxValue(int[][] grid) {
        //边界条件判断
        if (grid==null||grid.length==0)
            return 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m + 1][n + 1];
        /**
         * f(i,j) = max[f(i-1,j),f(i,j-1)]+grid(i,j);
         */
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }
}
