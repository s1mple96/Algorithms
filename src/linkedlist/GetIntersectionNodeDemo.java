package linkedlist;

import doublepointer.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author s1mple
 * @create 2021/5/20-13:38
 */
public class GetIntersectionNodeDemo {

    /**
     * 双指针方法
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //统计链表的A和链表B的长度
        int lenA = length(headA);
        int lenB = length(headB);

        //如果长度不一样,节点多的先走,直到他们长度相同为止
        while (lenA != lenB) {
            if (lenA > lenB) {
                //如果链表A长,那么链表A先走
                headA = headA.next;
                lenA--;
            } else {
                headB = headB.next;
                lenB--;
            }
        }
        //然后开始比较,如果他两不相等一直走下去
        while (headA.val != headB.val) {
            headA = headA.next;
            headB = headB.next;
        }
        /**
         * 走到最后,最终会有两种可能,一直是headA为空,一种就是headA不为空有交点
         */
        return headA;
    }

    //统计链表的长度
    private int length(ListNode node) {
        int length = 0;
        while (node != null) {
            node = node.next;
            length++;
        }
        return length;
    }


    /**
     * set方法
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
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
