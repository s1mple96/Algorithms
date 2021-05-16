package dp;
//给定一个字符串 s ，找到其中最长的回文子序列，并返回该序列的长度。可以假设 s 的最大长度为 1000 。
//
//
//
// 示例 1:
//输入:
//
// "bbbab"
//
//
// 输出:
//
// 4
//
//
// 一个可能的最长回文子序列为 "bbbb"。
//
// 示例 2:
//输入:
//
// "cbbd"
//
//
// 输出:
//
// 2
//
//
// 一个可能的最长回文子序列为 "bb"。
//
//
//
// 提示：
//
//
// 1 <= s.length <= 1000
// s 只包含小写英文字母
//
// Related Topics 动态规划
// 👍 441 👎 0
/**
 * @author s1mple
 * @create 2021/5/14-16:25
 */
public class GetLongestPalindromeSubseq {

    /**
     * 我们定义dp[i][j]表示字符串从i到j之间的最长回文子序列
     *  1.如果s.charAt(i) == s.charAt(j),也就是说两头的字符串是一样的,他们可以和中间的最长回文子串序列构成一个更长的回文子序列
     *      即dp[i][j] = dp[i+1][j-1]+2
     *  2.如果s.charAt(i) != s.charAt(j),说明i和j指向的字符是不相等的,我们可以截取,要么去掉i指向的字符,要么去掉j指向的字符,然后去最大值
     *      即dp[i][j] = Math.max(dp[i][j-1],dp[i+1][j])
     */
    public int longestPalindromeSubseq(String s) {
        int length = s.length();
        int[][] dp = new int[length][length];
        //这里i要从最后一个开始遍历
        for (int i = length - 1; i >= 0; i--) {
            //单个字符也是一个回文串
            dp[i][i] = 1;
            //j从i的下一个开始
            for (int j = i + 1; j < length; j++) {
                //下面是递推公式
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][length - 1];
    }
}
