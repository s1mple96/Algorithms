package linkedlist;

import doublepointer.ListNode;

import java.util.Stack;

/**
 * @author s1mple
 * @create 2021/5/21-10:47
 */
public class ReversePrintDemo {
    /**
     * 递归
     * @param head
     * @return
     */
    public int[] reversePrint(ListNode head) {
        int count = length(head);
        int[] res = new int[count];
        reversePrintHelpler(head.next,res,count-1);
        return res;
    }
    public void reversePrintHelpler(ListNode head, int[] res, int index) {
        if (head == null) {
            return;
        }
        reversePrintHelpler(head.next, res, index - 1);
        res[index] = head.val;
    }
    private int length(ListNode head) {
        int count = 0;
        ListNode dummy = head;
        while (dummy != null) {
            count++;
            dummy = dummy.next;
        }
        return count;
    }

    /**
     * 栈
     * @param head
     * @return
     */
    public int[] reversePrint2(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        int size = stack.size();
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = stack.pop().val;
        }
        return res;
    }

    public static int[] reversePrint3(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
//        ListNode temp = head;
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        int[] res = new int[stack.size()];
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            res[i] = stack.pop().val;
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node3 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        node.next = node3;
        node3.next = node2;
        int[] ints = reversePrint3(node);
        System.out.println(ints);
    }
}
