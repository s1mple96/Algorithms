package doublepointer;

/**
 * @author s1mple
 * @create 2021/5/18-19:38
 */
public class HasCycleDemo {

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        //快慢两个指针
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            //慢指针每次走一步
            slow = slow.next;
            //快指针每次走两步
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
