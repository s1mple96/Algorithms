package other;

/**
 * @author s1mple
 * @create 2021/5/28-18:07
 */
public class CompressStringDemo {

    public String compressString(String S) {
        //边界条件判断
        if (S == null || S.length() == 0) {
            return S;
        }
        StringBuilder res = new StringBuilder();
        //当前字符
        char curChar = S.charAt(0);
        //当前字符的数量
        int curCharCount = 1;
        for (int i = 1; i < S.length(); i++) {
            //如果当前字符串有重复的,统计当前字符的数量
            if (S.charAt(i) == curChar) {
                curCharCount++;
                continue;
            }
            //走到这里,说明遇到了新的字符
            //这里先把当前字符和他的数量加入到res中
            res.append(curChar).append(curCharCount);
            //然后让当前字符指向新的字符,并且数量也要重新赋值为1
            curChar = S.charAt(i);
            curCharCount = 1;
        }
        //因为上面计算的时候会遗漏最后一个字符和他的数量
        //这里要添加到res中
        res.append(curChar).append(curCharCount);
        return String.valueOf(res);
    }
}
