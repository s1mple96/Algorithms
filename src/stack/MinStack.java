package stack;

import javax.swing.*;
import java.nio.channels.IllegalSelectorException;
import java.util.Stack;

/**
 * @author s1mple
 * @create 2021/5/22-4:19
 */
public class MinStack {
    private Stack<StackNode> stack = new Stack<>();

    //入栈
    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(new StackNode(x, x));
        } else {
            stack.push(new StackNode(x, Math.min(x, min())));
        }
    }

    //出栈
    public void pop() {
        if (stack.isEmpty()) {
            throw new IllegalStateException("栈为空");
        } else {
            stack.pop();
        }
    }

    public int top() {
        if (stack.isEmpty()) {
            throw new IllegalStateException("栈为空");
        }
        return stack.peek().val;
    }

    public int min() {
        if (stack.isEmpty()) {
            throw new IllegalStateException("栈为空");
        }
        return stack.peek().min;
    }
}

class StackNode {
    public int val;
    public int min;

    public StackNode(int val, int min) {
        this.val = val;
        this.min = min;
    }
}
