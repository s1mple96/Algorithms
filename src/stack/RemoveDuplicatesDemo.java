package stack;

import java.util.Stack;

/**
 * @author s1mple
 * @create 2021/5/21-16:51
 */
public class RemoveDuplicatesDemo {
    public String removeDuplicates(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        int index = 0;
        int length = s.length();
        while (index < length) {
            char current = chars[index++];
            if (!stack.empty() && stack.peek() == current) {
                //如果栈顶的值和当前遍历的值相同,他两直接消失
                stack.pop();
            } else {
                //如果栈为空,或者栈顶元素和当前值不同,就把当前值压入栈
                stack.push(current);
            }
        }
        //下面是把栈中的元素转化为字符串
        StringBuilder stringBuilder = new StringBuilder(stack.size());
        while (!stack.empty()) {
            stringBuilder.append(stack.pop());
        }
        return stringBuilder.reverse().toString();
    }
}
