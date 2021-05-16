package dp;

/**
 * @author s1mple
 * @create 2021/5/15-19:50
 */
public class GetLongestPalindrome {
    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        int start = 0;
        int maxLen = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = 1; j < s.length(); j++) {
                //截取所有子串，然后在逐个判断是否是回文的
                if (isPalindrome(s, i, j)) {
                    if (maxLen < j - 1 + 1) {
                        start = i;
                        maxLen = j - i + 1;
                    }
                }
            }
        }
        return s.substring(start, start + maxLen);
    }

    //判断是否是回文串
    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}
