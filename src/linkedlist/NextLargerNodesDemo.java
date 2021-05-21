package linkedlist;

import doublepointer.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author s1mple
 * @create 2021/5/21-11:31
 */
public class NextLargerNodesDemo {
    /**
     * 通过剪枝,减少运算
     * @param head
     * @return
     */
    public int[] nextLargeNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        //链表元素存储到集合中
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int[] res = new int[list.size()];
        for (int i = res.length - 1; i >= 0; i--) {
            int j = i + 1;
            int num = 0;
            if (j < res.length) {
                num = list.get(j);
            }
            while (j < res.length) {
                if (num > list.get(i)) {
                    //如果找到就停止while循环
                    res[i] = num;
                    break;
                } else if (num == 0) {
                    break;
                } else {
                    num = res[j++];
                }
            }
        }
        return res;
    }
    /**
     * 使用栈求解
     * @param head
     * @return
     */
    public int[] nextLargerNodes3(ListNode head) {
        List<Integer> list = new ArrayList<>();
        //链表元素存储到集合中
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        //栈中存储的是元素的下标,并且从栈底到栈顶元素在集合中对应的值是从大到小的
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            while (!stack.isEmpty() && list.get(stack.peek()) < list.get(i)) {
                //如果栈顶元素对应的值小于当前的值,说明栈顶元素遇到了比他小的
                int index = stack.pop();
                res[index] = list.get(i);
            }
            stack.push(i);
        }
        return res;
    }
    /**
     * 暴力求解
     * @param head
     * @return
     */
    public int[] nextLargerNodes2(ListNode head) {
        List<Integer> list = new ArrayList<>();
        //链表元素存储到集合中
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {

                if (list.get(j) > list.get(i)) {
                    res[i] = list.get(j);
                    break;
                }
            }
        }
        return res;
    }
}
