package linkedlist;

import doublepointer.ListNode;

import java.util.Stack;

/**
 * @author s1mple
 * @create 2021/5/19-19:47
 */
public class IsPalindromeDemo {

    /**
     * 递归方式
     *
     * @param head
     * @return
     */
    ListNode temp;
    public boolean isPalindrome3(ListNode head) {
        temp = head;
        return check(head);
    }

    private boolean check(ListNode head) {
        if (head == null) {
            return true;
        }
        boolean res = check(head.next) && (temp.val == head.val);
        temp = temp.next;
        return res;
    }
    /**
     * 使用栈解决
     * @param head
     * @return
     */
    public boolean isPalindrome2(ListNode head) {
        ListNode temp = head;
        Stack<Integer> stack = new Stack<>();
        //把链表节点的值存放到栈中
        while (temp != null) {
            stack.push(temp.val);
            temp = temp.next;
        }
        //然后再出栈
        while (head != null) {
            if (head.val != stack.pop()) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    /**
     * 快慢指针
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head, slow = head;
        //通过快慢指针找到中点
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //如果fast不为空,说明链表的长度是奇数个
        if (fast != null) {
            slow = slow.next;
        }
        //反转后半部分链表
        slow = reverse(slow);

        fast = head;
        while (slow != null) {
            //然后比较,判断节点值是否相等
            if (fast.val != slow.val) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }

    //反转链表
    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }
}
