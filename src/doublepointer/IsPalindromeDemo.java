package doublepointer;

/**
 * @author s1mple
 * @create 2021/5/18-19:03
 */
public class IsPalindromeDemo {
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            //left是左指针,如果不是字母和数字就要过滤掉
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            //right也一样,如果不是字母和数字就要过滤掉
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            //然后判断这两个字符是否相同,如果不相同直接返回false,这里是先把字符串全部转换为小写
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            //如果left和right指向的字符忽略大小写相等的话,这两个指针要分别往中间移一步
            left++;
            right--;
        }
        //如果都比较完了,说明是回文,返回true
        return true;
    }
}
