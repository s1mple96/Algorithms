package 动态规划问题;

//一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。在每次预约服务之间要有休息时间，因此她不能接受相邻的预约。给定一个预约请求序列，替按摩
//师找到最优的预约集合（总预约时间最长），返回总的分钟数。
//
// 注意：本题相对原题稍作改动
//
//
//
// 示例 1：
//
// 输入： [1,2,3,1]
//输出： 4
//解释： 选择 1 号预约和 3 号预约，总时长 = 1 + 3 = 4。
//
//
// 示例 2：
//
// 输入： [2,7,9,3,1]
//输出： 12
//解释： 选择 1 号预约、 3 号预约和 5 号预约，总时长 = 2 + 9 + 1 = 12。
//
//
// 示例 3：
//
// 输入： [2,1,4,5,3,1,1,3]
//输出： 12
//解释： 选择 1 号预约、 3 号预约、 5 号预约和 8 号预约，总时长 = 2 + 4 + 3 + 3 = 12。
//
// Related Topics 动态规划
// 👍 195 👎 0

/**
 * @author s1mple
 * @create 2021/5/14-13:09
 */
public class GetMaxMassage {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 1, 4, 5, 3, 1, 1, 3};
        GetMaxMassage massage = new GetMaxMassage();
        int res = massage.massage(nums);
        System.out.println(res);
    }

    /**
     *
     *  一.确定状态:
     *      定义一个二维数组dp[length][2]
     *      dp[i][0]表示第i+1个 预约没有接 的最长总预约时间
     *      dp[i][1]表示第i+1个 预约了接了 的最长总预约时间
     *  二.找到转移公式:
     *      dp[i][0] = max(dp[i-1][0],dp[i-1][1])
     *      dp[i][1] = dp[i-1][0]+nums[i]
     *
     *  三.边界条件判断:
     *      dp[0][0] = 0 第一个没接
    *       dp[0][1] = nums[0],第一个接了
     */
    public int massage(int[] nums) {
        //边界条件判断
        if (nums == null || nums.length ==0)
            return 0;
        int length = nums.length;
        int[][] dp = new int[length][2];
        dp[0][0] = 0;//第1个 没接
        dp[0][1] = nums[0];//第1个 接了
        for (int i = 1; i < length; i++) {
            //下面是递推公式
            //若第1个 没接 ,则最大预约数
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            //若第1个 接了 ,则最大预约数
            dp[i][1] = dp[i - 1][0] + nums[i];
        }
        //取两者的最大值
        return Math.max(dp[length - 1][0], dp[length - 1][1]);
    }
}
