package 动态规划问题;
//一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
//
// 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
//
// 问总共有多少条不同的路径？
//
//
//
// 示例 1：
//
//
//输入：m = 3, n = 7
//输出：28
//
// 示例 2：
//
//
//输入：m = 3, n = 2
//输出：3
//解释：
//从左上角开始，总共有 3 条路径可以到达右下角。
//1. 向右 -> 向下 -> 向下
//2. 向下 -> 向下 -> 向右
//3. 向下 -> 向右 -> 向下
//
//
// 示例 3：
//
//
//输入：m = 7, n = 3
//输出：28
//
//
// 示例 4：
//
//
//输入：m = 3, n = 3
//输出：6
//
//
//
// 提示：
//
//
// 1 <= m, n <= 100
// 题目数据保证答案小于等于 2 * 109
//
// Related Topics 数组 动态规划
// 👍 988 👎 0

import java.util.Arrays;

/**
 * @author s1mple
 * @create 2021/5/14-13:52
 */
public class GetUniquePaths {

    /**
     * 因为只能从上面或左边走过来,所以递推公式是:
     * dp[i][j] = dp[i-1][j] +dp[i][j-1]
     * dp[i-1][j]表示的是从上面走过来的路径条数
     * dp[i][j-1]表示的是从左边走过来的路径条数
     * 边界条件:第一行和第一列都是1
     */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        //第一列都是1
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        //第一行都是1
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        //这里是递归公式
        for (int i=1;i<m;i++)
            for (int j=1;j<n;j++)
                dp[i][j] = dp[i-1][j]+dp[i][j-1];
        return dp[m - 1][n - 1];
    }

    /**
     * 上面的二维数组的递推公式,当前坐标的值只和左边与上面的值有关,和其他的无关,这样
     * 二维数组造成了大量的空间浪费,所以我们可以把他改成一维数组.
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths2(int m, int n) {
        int[] dp = new int[m];
        Arrays.fill(dp, 1);
        for (int j = 1; j < n; j++) {
            for (int i = 1; i < m; i++) {
                dp[i] += dp[i-1];
            }
        }
        return dp[m - 1];
    }

}
