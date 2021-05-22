package stack;

import java.util.Stack;

/**
 * @author s1mple
 * @create 2021/5/22-3:33
 */
public class IsValidDemo {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        //遍历所有元素
        for (char c : chars) {
            //如果是左括号,就他们对应的右括号入栈
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || stack.pop() != c) {
                /**
                 * 如果遇到右括号:
                 *  1.查看栈是否为空,如果为空,说明不能构成有效括号,直接返回false
                 *  2.如果栈不为空,栈顶元素出栈,然后判断出栈的元素是否等于这个右括号,
                 *  如果不等于,说明不匹配,直接返回false
                 */
                return false;
            }
        }
        //如果最后栈为空,说明完全匹配,是有效的括号
        //否则不完全匹配,就不是有效 的括号
        return stack.isEmpty();
    }
}
