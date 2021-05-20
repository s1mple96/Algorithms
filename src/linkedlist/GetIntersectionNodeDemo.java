package linkedlist;

import doublepointer.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author s1mple
 * @create 2021/5/20-13:38
 */
public class GetIntersectionNodeDemo {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //创建集合set
        Set<ListNode> set = new HashSet<>();
        //先把链表A的节点全部存放到集合set中
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }

        //然后访问链表B的节点,判断集合中是否包含链表B的节点,如果包含直接返回
        while (headB != null) {
            if (set.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        //如果集合set中不包含链表B的任何一个节点,说明他们没有焦点,返回null
        return null;
    }
}
