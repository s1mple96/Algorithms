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
        //下面4行是空判断
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
        //下面4行是空判断
        if (linked1==null)
            return linked2;
        if (linked2==null)
            return linked1;
        ListNode dummy = new ListNode(0);//新的链表
        ListNode curr = dummy;//指针
        while (linked1 != null && linked2 != null) {
           //比较一下哪个小酒放到新链表中
            if (linked1.val <= linked2.val) {
                curr.next = linked1;
                linked1 = linked1.next;
            } else {
                curr.next = linked2;
                linked2 = linked2.next;
            }
            curr = curr.next;
        }
        //然后把那个不为空的链表挂到新的链表中
        curr.next = linked1 == null ? linked2 : linked1;
        return dummy.next;
    }
}
