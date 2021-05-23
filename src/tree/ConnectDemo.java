package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author s1mple
 * @create 2021/5/23-1:46
 */
public class ConnectDemo {

    public Node connect2(Node root) {
        if (root == null) {
            return root;
        }
        //cur我们可以把他看成是每一层的链表
        Node cur = root;
        while (cur != null) {
            //遍历当前层的时候,为了方便操作在一下层前面添加一个哑结点(注意这里是访问当前层的节点,然后再把下一场的节点穿起来)
            Node dummy = new Node(0);
            //pre表示访问一下层节点的前一个节点
            Node pre = dummy;
            while (cur != null) {
                if (cur.left != null) {
                    //如果当前节点的左子节点不为空,就让pre节点
                    //的next指向他,也就是吧他串起来
                    pre.next = cur.left;
                    //然后再更新pre
                    pre = pre.next;
                }
                //同理可以参考左子树
                if (cur.right != null) {
                    pre.next = cur.right;
                    pre = pre.next;
                }
                //继续访问这一行的下一个节点
                cur = cur.next;
            }
            //把下一层串联成一个链表后,让他赋值给cur
            //后继续循环,直接cur为空为止
            cur = dummy.next;
        }
        return root;
    }

    /**
     * BFS解法
     * @param root
     * @return
     */
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            //每一层的数量
            int levelCount = queue.size();
            //前一个节点
            Node pre = null;
            for (int i = 0; i < levelCount; i++) {
                //出队
                Node node = queue.poll();
                //如果pre为空就表示node节点是这一行的第一个
                //如果前一个节点指向他,否则就让前一个节点指向他
                if (pre != null) {
                    pre.next = node;
                }
                //然后再让当前节点成为前一个节点
                pre = node;
                //左右子节点如果不为空就入队
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return root;
    }
}

class Node {
    int val;
    Node left;
    Node right;
    Node next;

    public Node(int val) {
        this.val = val;
    }
}

