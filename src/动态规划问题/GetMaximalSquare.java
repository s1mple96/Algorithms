package 动态规划问题;

//在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
//
//
//
// 示例 1：
//
//
//输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"]
//,["1","0","0","1","0"]]
//输出：4
//
//
// 示例 2：
//
//
//输入：matrix = [["0","1"],["1","0"]]
//输出：1
//
//
// 示例 3：
//
//
//输入：matrix = [["0"]]
//输出：0
//
//
//
//
// 提示：
//
//
// m == matrix.length
// n == matrix[i].length
// 1 <= m, n <= 300
// matrix[i][j] 为 '0' 或 '1'
//
// Related Topics 动态规划
// 👍 764 👎 0

/**
 * @author s1mple
 * @create 2021/5/14-12:06
 */
public class GetMaximalSquare {

    /**
     *  一.确定状态:
     *      定义二维数组dp[m][n],
     *      其中dp[i][j]表示的是在矩阵中坐标(i,j)为右下角的最大正方形边长
     *      如果matrix[i][j]是0，就没法构成正方形。所以dp[i][j]=0
     *      如果matrix[i][j]是1,说明他可以构成一个正方形，且这个正方形边长最小是1
     *
     *  二.找到转移公式:
     *      如果坐标(i,j)为1，那么以他为右下角的最大正方形边长是
     *          (dp[[i-1][j-1]，上边的高度，左边的高度，这三个中最小的+1
     *      这里有个问题就是，如果（i，j)是1，我们有必要往他的上边和左边查找吗？
     *      很显然没必要，上边可以用dp[i-1][j]来表示，左边可以用dp[i][j-1]来表示
     *      所以我们可以得出递推公式
     *      如果坐标(i,j)为0，则dp[i][j]=0;
     *      如果坐标(i,j)为1，则dp[i][j]=min(dp[i-1][j],dp[i][j-1],dp[i-1][j-1])+1
     *  三.边界条件判断:
     *      如果坐标(i,j)为0
     *      则dp[i][j] = 0
     *
     */
    public int maximalSquare(char[][] matrix) {
        //二维矩阵的宽和高
        int height = matrix.length;
        int width = matrix[0].length;
        int[][] dp = new int[height][width];
        int maxSide = 0;//最大正方形的宽
        for (int i = 1; i < height; i++) {
            for (int j = 1; j < width; j++) {
                //递推公式
                dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                //记录最长的边长
                maxSide = Math.max(maxSide, dp[i][j]);
            }
        }
        //返回正方形的面积
        return maxSide * maxSide;
    }
}
