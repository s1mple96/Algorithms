package dp;
//输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
//
// 要求时间复杂度为O(n)。
//
// 示例1:
//
// 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
//
//
//
// 提示：
//
//
// 1 <= arr.length <= 10^5
// -100 <= arr[i] <= 100
//
//
// 注意：本题与主站 53 题相同：https://leetcode-cn.com/problems/maximum-subarray/
//
//
// Related Topics 分治算法 动态规划
// 👍 269 👎 0

/**
 * @author s1mple
 * @create 2021/5/14-11:14
 */
public class GetMaxSubArray {


    public static void main(String[] args) {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        GetMaxSubArray array = new GetMaxSubArray();
        int res = array.maxSubArray(nums);
        System.out.println(res);
    }


    /**
     *
     * 一.确定状态:
     *      定义dp[i] 表示数组中前i+1个元素构成的连续子数组的最大和.
     * 二.找到转移公式:
     *      如果要计算前i+1个元素构成的连续子数组的最大和,也就是计算dp[i],只需要判断dp[i-1]是否大于0
     *      如果dp[i-1]大于0,就继续累加:dp[i]=dp[i-1]+num[i].
     *      如果dp[i-1]小于0,直接把前面的设计,重新开始计算,直接让:dp[i]=num[i]
     *      转移公式:dp[i]=num[i]+max(dp[i-1],0)
     * 三.边界条件判断:
     *      当i等于0时,也就是前1个元素,他能构成的最大和也就是他自己,所以:dp[0]=num[0]
     *
     */
    public int maxSubArray(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length];
        //边界条件
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < length; i++) {
            //转移公式
            dp[i] = Math.max(dp[i - 1], 0) + nums[i];
            //记录最大值
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
