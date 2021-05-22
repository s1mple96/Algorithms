package stack;

import java.util.Stack;

/**
 * @author s1mple
 * @create 2021/5/22-3:58
 */
public class ValidateStackSequencesDemo {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        //创建一个栈
        Stack<Integer> stack = new Stack<>();
        //记录popped数组访问到哪一个元素了
        int index = 0;
        //遍历pushed数组中的所有元素
        for (int num : pushed) {
            stack.push(num);//把当前元素push到栈中
            while (!stack.isEmpty() && stack.peek() == popped[index]) {
                //如果栈顶元素等于popped[index],就让栈顶元素出栈
                stack.pop();
                index++;
            }
        }
        return stack.isEmpty();
    }

}
