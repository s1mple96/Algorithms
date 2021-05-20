package linkedlist;

import doublepointer.ListNode;

/**
 * @author s1mple
 * @create 2021/5/20-19:03
 */
public class DeleteNodeDemo {
    public ListNode deleteNode(ListNode head, int val) {
        //边界条件判断
        if (head == null) {
            return head;
        }
        //如果要删除的是头节点,直接返回头节点的下一个节点即可
        if (head.val == val) {
            return head.next;
        }
        ListNode cur = head;
        //找到要删除节点的上一个节点
        while (cur.next != null && cur.next.val != val) {
            cur = cur.next;
        }
        //删除节点
        cur.next = cur.next.next;
        return head;
    }
}
