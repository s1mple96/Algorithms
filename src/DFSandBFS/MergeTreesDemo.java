package DFSandBFS;

import dataStructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author s1mple
 * @create 2021/6/3-22:40
 *
 * 总结:
 *  DFS和BFS
 */
public class MergeTreesDemo {
    /**
     * DFS
     * @param t1
     * @param t2
     * @return
     */
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        //如果两个节点都为空,直接返回空就行了
        if (t1 == null && t2 == null) {
            return null;
        }
        //如果t1节点为空,就返回t2节点
        if (t1 == null) {
            return t2;
        }
        //如果t2节点为空,就返回t1节点
        if (t2 == null) {
            return t1;
        }
        //走到这一步,说明这两个节点都不为空,然后需要把这两个节点合并成一个新的节点
        TreeNode newNode = new TreeNode(t1.val + t2.val);
        //当前节点t1和t2合并完成后,还要继续合并t1和t2的子节点
        newNode.left = mergeTrees(t1.left, t2.left);
        newNode.right = mergeTrees(t1.right, t2.right);
        return newNode;
    }

    /**
     * BFS
     * @param t1
     * @param t2
     * @return
     */
    public TreeNode mergeTrees2(TreeNode t1, TreeNode t2) {
        //如果t1节点为空,就返回t2
        if (t1 == null) {
            return t2;
        }
        //如果t2节点为空,就返回t1
        if (t2 == null) {
            return t1;
        }
        //队列中两棵树的节点同时存在
        Queue<TreeNode> queue = new LinkedList<>();
        //把这两棵树的节点同时入队
        queue.add(t1);
        queue.add(t2);
        while (!queue.isEmpty()) {
            //两棵树的节点同时入队
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();
            //把这两个节点的值相加,然后合并到第1棵树的节点上
            node1.val += node2.val;
            if (node1.left == null) {
                //如果node1左子节点为空,我们直接让node2的左子节点成为node1的左子节点
                node1.left = node2.left;
            } else {
                //执行到这一步,说明node1的左子节点不为空
                //如果node2的左子节点为空就不需要合并了
                //只有node2的左子节点为空的时候才需要合并
                if (node2.left != null) {
                    queue.add(node1.left);
                    queue.add(node2.left);
                }
            }
            //原理同上,上面判断的是左子节点,这里判断的是右子节点
            if (node1.right == null) {
                node1.right = node2.right;
            } else {
                if (node2.right != null) {
                    queue.add(node1.right);
                    queue.add(node2.right);
                }
            }
        }
        //把第2棵树合并到第1棵树上,所以返回的是第1棵树
        return t1;
    }
}
