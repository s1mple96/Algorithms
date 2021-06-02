package other;

import java.util.Stack;

/**
 * @author s1mple
 * @create 2021/5/26-13:55
 */
public class AddStringsDemo {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0 || carry != 0) {
            int x = j < 0 ? 0 : num1.charAt(i--) - '0';
            int y = j < 0 ? 0 : num2.charAt(j--) - '0';
            int sum = x + y + carry;
            sb.append(sum % 10);//添加到字符串尾部
            carry = sum / 10;
        }
        return sb.reverse().toString();
    }

    /**
     *  使用栈方法实现
     * @param num1
     * @param num2
     * @return
     */
    public String addStrings2(String num1, String num2) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0 || carry != 0) {
            carry += i >= 0 ? num1.charAt(i--) - '0' : 0;
            carry += j >= 0 ? num2.charAt(j--) - '0' : 0;
            stack.push(carry % 10);
            carry = carry / 10;
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}
