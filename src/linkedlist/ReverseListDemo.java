package linkedlist;

import doublepointer.ListNode;

import java.util.Stack;

/**
 * @author s1mple
 * @create 2021/5/19-17:47
 */
public class ReverseListDemo {
    /**
     * 递归方法
     * @param head
     * @return
     */
    public ListNode reverseList3(ListNode head) {
        //递归终止
        if (head == null || head.next == null) {
            return head;
        }
        //保存当前节点的下一个节点
        ListNode next = head.next;
        //从当前节点的下一个节点开始递归调用
        ListNode reverse = reverseList3(next);
        /**
         * reverse是反转之后的链表,因为函数reverseList表示的是对链表的反转
         * ,所以反转完之后next肯定是链表reverse的尾结点,然后我们再把当前节点
         * head挂到next节点的后面就完成了链表的反转
         */
        next.next = head;
        //这里head相当于变成了尾结点,尾结点都是为空的,否则会构成环
        head.next = null;
        return reverse;
    }

    /**
     * 双链表方法
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        //申请节点，pre和 cur，pre指向null
        ListNode pre = null;
        ListNode cur = head;
        while(cur!=null) {
            //记录当前节点的下一个节点
            ListNode tmp = cur.next;
            //然后将当前节点指向pre
            cur.next = pre;
            //pre和cur节点都前进一位
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    /**
     * 栈方法
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        //把链表节点全部摘掉放到栈中
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        if (stack.isEmpty()) {
            return null;
        }
        ListNode node = stack.pop();
        ListNode dummy = node;
        //栈中的节点全部出栈,然后重新连成一个新的链表
        while (!stack.isEmpty()) {
            ListNode tempNode = stack.pop();
            node.next = tempNode;
            node = node.next;
        }
        //最后一个节点就是反转前的头节点,一定要让他的next等于空,否则会构成环
        node.next = null;
        return dummy;
    }
}
