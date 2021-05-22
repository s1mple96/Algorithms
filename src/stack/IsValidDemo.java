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
                //否则就只能是右括号了.
                //1.如果栈为空,说明括号无法匹配
                //2.如果栈不为空,说明栈顶元素就要出栈,和这个右括号比较.
                //如果栈顶元素不等于这个右括号,说明无法匹配,直接返回false
                return false;
            }
        }
        //如果最后栈为空,说明完全匹配,是有效的括号
        //否则不完全匹配,就不是有效 的括号
        return stack.isEmpty();
    }
}
