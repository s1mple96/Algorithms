package dp;

/**
 * @author s1mple
 * @create 2021/5/17-16:35
 */
public class GetMinDistance {

    /**
     * dp[i][j]表示把word1的前i个字符变成word2的前j个字符所需要的的最少编辑距离
     */
    public static int minDistance(String word1, String word2) {
        int length1 = word1.length();
        int length2 = word2.length();
        if (length1 * length2 == 0) {
            return length1 + length2;//如果有一个为空,直接返回另一个的长度即可
        }
        int dp[][] = new int[length1 + 1][length2 + 1];
        for (int i = 0; i <= length1; i++) {
            dp[i][0] = i;//边界条件,相当于word1的删除操作
        }
        for (int i = 0; i <= length2; i++) {
            dp[0][i] = i;//边界标记,相当于word2的删除操作
        }
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {//下面是递推公式
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
                }
            }
        }
        return dp[length1][length2];
    }

}
