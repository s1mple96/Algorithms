package stack;

import java.util.Stack;

/**
 * @author s1mple
 * @create 2021/5/22-4:13
 */
public class GetValidateStackSequencesDemo {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for (int num : pushed) {
            //pushed数组中的元素逐个入栈
            stack.push(num);
            while (!stack.isEmpty() && stack.peek() == popped[index]) {
                stack.pop();
                index++;
            }
        }
        return stack.isEmpty();
    }
}
