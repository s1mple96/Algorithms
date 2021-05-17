package dp;

import java.util.Arrays;

/**
 * @author s1mple
 * @create 2021/5/17-12:55
 */
public class GetLengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        //边界条件判断
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        //初始化数组dp的每个值为1
        Arrays.fill(dp, 1);
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                /**
                 * 如果当前的值num[i]大于nums[j],说明nums[i]可以和
                 * nums[j]结尾的上升序列构成一个新的上升序列
                 */
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    //记录构成的最大值
                    max = Math.max(max, dp[i]);
                }
            }
        }
        return max;
    }
}
