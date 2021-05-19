package doublepointer;

import java.util.List;

/**
 * @author s1mple
 * @create 2021/5/19-11:09
 */
public class RotateRightDemo {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        //链表的长度
        int len = 1;
        //统计链表的长度,顺便找到链表的尾结点
        while (fast.next != null) {
            len++;
            fast = fast.next;
        }
        //首尾相连,先构成环
        fast.next = head;
        //慢指针移动的步数
        int step = len - k % len;
        //移动步数,这里大于1实际上就是少移动一步
        while (step-- > 1) {
            slow = slow.next;
        }
        //temp就是需要返回的节点
        ListNode temp = slow.next;
        //因为链表是环形的,slow就相当于尾结点了
        //直接让他的next等于空
        slow.next = null;
        return temp;
    }
}
