package linkedlist;

import doublepointer.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author s1mple
 * @create 2021/5/20-17:16
 */
public class DetectCycleDemo {

    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            //如果重复重新说明有环.如果set中有该元素,将返回false
            if (!set.add(head)) {
                return head;
            }
            //否则就把当前节点加入到集合中
            head = head.next;
        }
        return null;
    }

    public ListNode detectCycle2(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            //快慢指针,快指针每次走两步,慢指针每次走一步
            fast = fast.next.next;
            slow = slow.next;
            //先判断是否有环
            if (slow == fast) {
                //确定有换之后才能找到环的入口
                while (head != slow) {
                    //两个指针,一个从头节点开始,一个从相遇点开始每次走一步,知道再次相遇为止
                    head = head.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }
}
