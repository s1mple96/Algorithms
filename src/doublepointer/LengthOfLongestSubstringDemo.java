package doublepointer;

import java.util.HashMap;

/**
 * @author s1mple
 * @create 2021/5/19-11:21
 */
public class LengthOfLongestSubstringDemo {

    public static void main(String[] args) {
        String s = "ABCABCD";
        int res = lengthOfLongestSubstring(s);
        System.out.println(res);
    }
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;

        for (int i = 0, j = 0; i < s.length(); i++) {
            //如果有重复的,就修改j的值
            if (map.containsKey(s.charAt(i))) {
                //j取的是重复元素位置的下一个值和j这两个值的最大值
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            //记录查找的最大值
            max = Math.max(max, i - j + 1);
        }
        //返回最大值
        return max;
    }
}
