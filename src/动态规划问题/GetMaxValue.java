package 动态规划问题;

/**
 * 礼物的最大值
 * 问题:在 一 个 m*n 的 棋 盘 的 每 一 格 都 放 有 一 个 礼 物 ，
 * 每 个 礼 物 都 有 一 定 的 价 值 （ 价 值 大 于 0）。
 * 你可以从棋盘的左上角开始拿格子里的礼物，
 * 并每次向右或者向下移动一格、直到 到达棋盘的右下角。
 * 给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值 的礼物？
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
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        //初始化dp最上面那一行,从左到右累加
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        //初始化dp的最左边一列,从上到下累加
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        /**
         * 下面是递推公式
         * f(i,j) = max[f(i-1,j),f(i,j-1)]+grid(i,j);
         */
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }

    /**
     *
     * @param grid
     * @return
     */
    public int maxValue2(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        //dp[i][j]表示从grid[0][0]到grid[i-1][j-1]时的最大价值
        int[][] dp = new int[row + 1][column + 1];
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i - 1][j - 1];
            }
        }
        return dp[row][column];
    }
}
