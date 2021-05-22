package stack;

import java.util.Stack;

/**
 * @author s1mple
 * @create 2021/5/22-4:38
 */
public class CQueueDemo {
    public Stack<Integer> stackPush;
    public Stack<Integer> stackPop;

    public CQueueDemo(Stack<Integer> stackPush, Stack<Integer> stackPop) {
        this.stackPush = new Stack<>();
        this.stackPop = new Stack<>();
    }

    public void appendTail(int value) {
        stackPush.push(value);
    }

    public int deleteHead() {
        if (stackPop.isEmpty()) {
            while (!stackPush.isEmpty()) {
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.isEmpty() ? -1 : stackPop.pop();
    }
}
