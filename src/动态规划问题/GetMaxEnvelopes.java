package 动态规划问题;
//给你一个二维整数数组 envelopes ，其中 envelopes[i] = [wi, hi] ，表示第 i 个信封的宽度和高度。
//
// 当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
//
// 请计算 最多能有多少个 信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
//
// 注意：不允许旋转信封。
//
//
// 示例 1：
//
//
//输入：envelopes = [[5,4],[6,4],[6,7],[2,3]]
//输出：3
//解释：最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
//
// 示例 2：
//
//
//输入：envelopes = [[1,1],[1,1],[1,1]]
//输出：1
//
//
//
//
// 提示：
//
//
// 1 <= envelopes.length <= 5000
// envelopes[i].length == 2
// 1 <= wi, hi <= 104
//
// Related Topics 二分查找 动态规划
// 👍 521 👎 0

import java.util.Arrays;

/**
 * @author s1mple
 * @create 2021/5/14-12:38
 */
public class GetMaxEnvelopes {

    /**
     * 关键问题是怎么对信封进行排序,我们可以先按照宽度进行升序排序,因为宽度是升序的,
     * 当我们从前往后的时候就可以忽略宽度,然后只需要比较高度即可,这个时候就可以转换为最长上升子序的问题了.
     * 如果宽度相同,我们在按照高度降序排序,为啥要降序,因为如果宽度相同的情况,在这些宽度相同的信封中我们
     * 最多只能选择一个,如果是升序的话,可能会有多个选择,只有降序才能满足这个条件.
     *
     */
    public int maxEnvelopes(int[][] envelopes) {
        //边界条件判断
        if (envelopes == null || envelopes.length == 0) {
            return 0;
        }
        //先对信封进行排序
        Arrays.sort(envelopes, (int[] arr1, int[] arr2) ->{
            if (arr1[0] == arr2[0]) {
                return arr2[1] - arr1[1];
            } else {
                return arr1[0] - arr2[0];
            }
        });
        return lengthOfLIS(envelopes);
    }

    //求最长上升子序列
    public int lengthOfLIS(int[][] nums) {
        int[] dp = new int[nums.length];
        //初始化数组dp的每个值为1
        Arrays.fill(dp, 1);
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                //如果当前的值nums[i]大于nums[j],说明nums[i]可以和
                //nums[j] 结尾的上升序列构成一个新的上升子序列
                if (nums[i][1] > nums[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            //记录构成的最大值
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
