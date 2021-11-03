package linkedlist;

import doublepointer.ListNode;

/**
 * @author s1mple
 * @create 2021/5/20-19:03
 */
public class DeleteNodeDemo {

    public ListNode deleteNode3(ListNode head, int val) {
        //初始化一个虚拟节点
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head;
        ListNode pre = dummy;
        while (cur != null) {
            if (cur.val == val) {
                //如果找到要删除的节点，直接把他删除
                pre.next = cur.next;
                break;
            }
            //如果没找到，pre指针和cur指针都同时往后 移动
            pre = cur;
            cur = cur.next;
        }
        //最后返回虚拟节点的下一个节点即可
        return dummy.next;
    }

    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        if (head.val == val) {
            return head.next;
        }
        head.next = deleteNode(head.next, val);
        return head;
    }


    /**
     * 指针解法
     * @param head
     * @param val
     * @return
     */
    public ListNode deleteNode2(ListNode head, int val) {
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
