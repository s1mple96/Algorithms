package linkedlist;

import doublepointer.ListNode;

import java.util.Stack;

/**
 * @author s1mple
 * @create 2021/5/20-18:21
 */
public class GetKthFromEndDemo {

    //全局变量,记录递归往回走的时候访问的节点数量
    int size;
    public ListNode getKthFromEnd(ListNode head, int k) {
        //边界条件判断
        if (head == null) {
            return head;
        }
        ListNode node = getKthFromEnd(head.next, k);
        ++size;
        //从后面数节点数小于k,返回空
        if (size < k) {
            return null;
        } else if (size == k) {
            //从后面数访问节点等于k,直接返回传递的节点k即可
            return head;
        } else {
            //从后面数访问的节点大于k,说明我们已经找到了,直接返回node即可
            return node;
        }
    }
    /**
     * 栈解法
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd3(ListNode head, int k) {
        Stack<ListNode> stack = new Stack<>();
        //链表节点入栈
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        //在出栈串成新的链表
        ListNode firstNode = stack.pop();
        while (--k > 0) {
            ListNode temp = stack.pop();
            temp.next = firstNode;
            firstNode = temp;
        }
        return firstNode;
    }

    /**
     * 双指针
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd2(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;
        //第一个指针先走k步
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        //然后两个指针在同时前进
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
