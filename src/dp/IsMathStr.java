package dp;

/**
 * @author s1mple
 * @create 2021/5/17-11:50
 */
public class IsMathStr {
    public boolean isMath(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 0; i < n; i++) {
            /*如果p的第1+1个字符也就是p.charAt(i)是"*"的话,
            那么他就可以把p的第i个字符给消掉(也就是匹配0次).
            我们只需要判断p的第i-1个字符和s的前0个字符是否匹配
            比如p是"a*b*",如果判断p的第4个字符
            "*"和s的前0个字符是否匹配,因为字符"*"可以消去
            前面的任意字符,只需要判断p的"a"和s的前0个字符是否匹配即可*/
            if (p.charAt(i) == '*' && dp[0][i - 1]) {
                dp[0][i + 1] = true;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.') {
                    dp[i + 1][j + 1] = dp[i][j];
                } else if (p.charAt(j) == '*') {
                    //递推公式
                    if (p.charAt(j - 1) == s.charAt(i) || p.charAt(j - 1) == '.') {
                        dp[i + 1][j + 1] = dp[i][j + 1];
                    }
                    dp[i + 1][j + 1] |= dp[i + 1][j - 1];
                }
            }
        }
        return dp[m][n];
    }
}
