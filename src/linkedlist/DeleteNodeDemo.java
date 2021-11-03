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
        //递归的终止条件就是当head等于空的时 候，我们直接返回head，因为一个空的链表我们是没法删除的，也就是下面这样
        if (head == null) {
            return head;
        }
        //如果head结点不等于空，并且head结点的值等于val，我们直接返回head结点的下一 个结点
        if (head.val == val) {
            return head.next;
        }
        //否则也就是说头结点是删不掉的，我们就递归调用，从头结点的下一个开始继续上面的 操作，直到删除为止
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
