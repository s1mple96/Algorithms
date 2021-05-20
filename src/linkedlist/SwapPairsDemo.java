package linkedlist;

import doublepointer.ListNode;

import java.util.List;

/**
 * @author s1mple
 * @create 2021/5/20-16:30
 */
public class SwapPairsDemo {

    public ListNode swapPairs(ListNode head) {
        int first;
        ListNode temp = head;
        while (temp != null && temp.next != null) {
            //直接交换链表节点的值
            first = temp.val;
            temp.val = temp.next.val;
            temp.next.val = first;
            temp = temp.next.next;
        }
        return head;
    }

    /**
     * 递归解决
     * @param head
     * @return
     */
    public ListNode swapPairs3(ListNode head) {
        //边界条件判断
        if (head == null || head.next == null) {
            return head;
        }
        //从第3个链表往后进行交换
        ListNode third = swapPairs3(head.next.next);
        /**
         * 从第3个链表往后都交换完了,我们只需要交换前面两个链表即可,
         * 这里我们把链表分为3组,分别是第1个节点,第2个节点,后面的所有节点,也就是1->2->3,我们要把他变成2->1->3
         */
        ListNode second = head.next;
        head.next = third;
        second.next = head;
        return second;
    }

    /**
     * 非递归解决
     * @param head
     * @return
     */
    public ListNode swapPairs2(ListNode head) {
        //链表至少有2个节点才能交换,否则就不要交换
        if (head == null || head.next == null) {
            return head;
        }
        //这里的first,second,third
        ListNode first = head;
        ListNode second;
        ListNode third;
        //这个是交换链表之后的尾节点,他的next要指向新交换的链表
        ListNode preLast = null;
        //这个只赋值一次,他是要返回的新链表的头节点
        ListNode newHead = head.next;
        //如果能交换就继续操作
        while (first != null && first.next != null) {
            //给second,third赋值
            second = first.next;
            third = second.next;
            //first 和second这两个节点交换
            first.next = third;
            second.next = first;
            //这个时候second就是交换之后新链表的头节点
            //如果preLast不为空,说明前面还有交换完成的链表
            //要让preLast的next指向新链表的头节点
            if (preLast != null) {
                preLast.next = second;
            }
            //因为first和second交换之后,first就变成新链表的尾结点了,把他保存在preLast中
            preLast = first;
            //前面两个交换了,然后从第三个开始继续操作
            first = third;
        }
        //返回新链表
        return newHead;
    }
}
