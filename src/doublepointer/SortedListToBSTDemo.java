package doublepointer;

import dp.TreeNode;


/**
 * @author s1mple
 * @create 2021/5/18-19:22
 */
public class SortedListToBSTDemo {
    public TreeNode sortedListToBST(ListNode head) {
        //边界条件的判断
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        //这里通过快慢指针找到链表的中间节点slow,pre就是中间
        //节点slow的前一个节点
        ListNode slow = head, fast = head, pre = null;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        return null;
    }
}
