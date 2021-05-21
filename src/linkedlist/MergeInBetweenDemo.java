package linkedlist;

import doublepointer.ListNode;

/**
 * @author s1mple
 * @create 2021/5/21-12:16
 */
public class MergeInBetweenDemo {

    /**
     * 递归写法
     * @param linked1
     * @param linked2
     * @return
     */
    public ListNode mergeTwoLists(ListNode linked1, ListNode linked2) {
        if (linked1 == null) {
            return linked2;
        }
        if (linked2 == null) {
            return linked1;
        }
        if (linked1.val < linked2.val) {
            linked1.next = mergeTwoLists(linked1.next, linked2);
            return linked1;
        } else {
            linked2.next = mergeTwoLists(linked2.next, linked1);
            return linked2;
        }
    }

    public ListNode mergeTwoLists2(ListNode linked1, ListNode linked2) {
        if (linked1 == null) {
            return linked2;
        }
        if (linked2 == null) {
            return linked1;
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (linked1 != null && linked2 != null) {
            //比较一下,哪个小就把哪个放到新的链表中
            if (linked1.val > linked2.val) {
                cur.next = linked2;
                linked2 = linked2.next;
            }
            cur = cur.next;
        }
        //然后把哪个不为空的链表挂到新的链表中
        cur.next = linked1 == null ? linked2 : linked1;
        return dummy.next;
    }
}
