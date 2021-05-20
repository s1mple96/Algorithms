package linkedlist;

import doublepointer.ListNode;

/**
 * @author s1mple
 * @create 2021/5/20-17:39
 */
public class RemoveNthFromEndDemo {
    /**
     * 递归方法
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int pos = length2(head, n);
        if (pos == n) {
            return head.next;
        }
        return head;
    }
    public int length2(ListNode node, int n) {
        if (node == null) {
            return 0;
        }
        int pos = length2(node.next, n) + 1;
        //获取要删除链表的前一个节点,就可以完成链表的删除
        if (pos == n + 1) {
            node.next = node.next.next;
        }
        return pos;
    }

    /**
     * 双指针方法
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd3(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        //fast移N步
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        //如果fast为空,表示删除的是头节点
        if (fast == null) {
            return head.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        //这里最终slow不是倒数第n个节点,他是倒数第n+1个节点
        //他的下一个节点的倒数第n个节点,所以删除的是他下一个节点
        slow.next = slow.next.next;
        return slow;
    }

    /**
     * 非递归解决
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode pre = head;
        int last = length(head) - n;
        //如果last等于0表示删除的是头节点
        if (last == 0) {
            return head.next;
        }
        //这里首先需要找到要删除节点的前一个节点
        for (int i = 0; i < last - 1; i++) {
            pre = pre.next;
        }
        //然后让前一个节点的next指向要删除节点的next
        pre.next = pre.next.next;
        return head;
    }

    private int length(ListNode head) {
        int length = 0;
        while (head != null) {
            head = head.next;
            length++;
        }
        return length;
    }

}
