package 动态规划问题;
//三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。实现一种方法，计算小孩有多少种上楼梯的方式。结果可能很大，你需要对结果模100
//0000007。
//
// 示例1:
//
//
// 输入：n = 3
// 输出：4
// 说明: 有四种走法
//
//
// 示例2:
//
//
// 输入：n = 5
// 输出：13
//
//
// 提示:
//
//
// n范围在[1, 1000000]之间
//
// Related Topics 动态规划
// 👍 54 👎 0
/**
 * @author s1mple
 * @create 2021/5/14-19:18
 */
public class GetWaysToStep {

    public int waysToStep(int n) {
        int[] dp = new int[n];
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 4;
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 4;
        for (int i = 3; i < n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007 + dp[i - 3];
            dp[i] %= 1000000007;
        }
        return dp[n - 1];
    }
}
