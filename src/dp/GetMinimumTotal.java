package dp;

import java.util.List;

/**
 * 求解三角形最小路径和
 * @author s1mple
 * @create 2021/5/17-11:05
 */
public class GetMinimumTotal {
    public int minimumTotal(List<List<Integer>> triangle) {
        //定义一个二维数组
        int[][] dp = new int[triangle.size() + 1][triangle.size() + 1];
        //从最后一行开始计算
        for (int i = triangle.size() - 1; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                //递推公式
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }
}
