package tree;

import 数据结构.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author s1mple
 * @create 2021/5/22-22:31
 */
public class IsSameTreeDemo {

    /**
     * 递归方法
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //如果都为空,我们就认为他是相同的
        if (p == null && q == null) {
            return true;
        }
        //如果一个为空,一个不为空,很明显不可能是相同的,直接返回false即可
        if (p == null || q == null) {
            return false;
        }
        //如果这两个节点都不为空,并且又不相等,所以他们也不可能是相同的树,直接返回false
        if (p.val != q.val) {
            return false;
        }
        //走到这一步说明节点p和q是完全相同的,我们只需要在比较他们的左右子节点即可
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    /**
     * 非递归方法,BFS
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree2(TreeNode p, TreeNode q) {
        //如果都为空我们就认为他们是相同的
        if (p == null && q == null) {
            return true;
        }
        //如果一个为空,一个不为空,直接返回false
        if (p == null || q == null) {
            return false;
        }
        Queue<TreeNode> queueP = new LinkedList<>();
        Queue<TreeNode> queueQ = new LinkedList<>();
        //如果p和q两个节点都不为空,就把他们加入到队列中
        queueP.add(p);
        queueQ.add(q);
        while (!queueP.isEmpty() && !queueQ.isEmpty()) {
            //分别出队
            TreeNode tempP = queueP.poll();
            TreeNode tempQ = queueQ.poll();
            //如果这两个节点的值不相同,直接返回false
            if (tempP.val != tempQ.val) {
                return false;
            }
            //如果对应的左子树不为空就加入到队列中
            if (tempP.left != null) {
                queueP.add(tempP.left);
            }
            if (tempQ.left != null) {
                queueQ.add(tempQ.left);
            }
            //注意这里没有直接判断两个左子节点是否一个为空一个不为空
            //而是通过对了的长度来判断的,只有两个左子节点都为空或者都不为空的时候,队列长度才会一样
            if (queueP.size() != queueQ.size()) {
                return false;
            }
            //右子节点同上
            if (tempP.right != null) {
                queueP.add(tempP.right);
            }
            if (tempQ.right != null) {
                queueQ.add(tempQ.right);
            }
            if (queueP.size() != queueQ.size()) {
                return false;
            }
        }
        //最后判断这两个队列是否都为空
        return queueP.isEmpty() && queueQ.isEmpty();
    }
}
